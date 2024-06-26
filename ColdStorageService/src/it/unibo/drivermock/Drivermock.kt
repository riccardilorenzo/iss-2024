/* Generated by AN DISI Unibo */ 
package it.unibo.drivermock

import it.unibo.kactor.*
import alice.tuprolog.*
import unibo.basicomm23.*
import unibo.basicomm23.interfaces.*
import unibo.basicomm23.utils.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import it.unibo.kactor.sysUtil.createActor   //Sept2023

//User imports JAN2024

class Drivermock ( name: String, scope: CoroutineScope, isconfined: Boolean=false  ) : ActorBasicFsm( name, scope, confined=isconfined ){

	override fun getInitialState() : String{
		return "s0"
	}
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		//val interruptedStateTransitions = mutableListOf<Transition>()
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						delay(200) 
						CommUtils.outmagenta("$name | Sto partendo...")
						CommUtils.outmagenta("$name | Invio la richiesta di store...")
						request("store", "store(10)" ,"coldstorageservice" )  
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t01",targetState="continueWork",cond=whenReply("storeAccepted"))
					transition(edgeName="t02",targetState="continueWork",cond=whenReply("storeRejected"))
				}	 
				state("continueWork") { //this:State
					action { //it:State
						CommUtils.outmagenta("$name | Lo storage ha gestito la mia richiesta, procedo...")
						if( checkMsgContent( Term.createTerm("storeAccepted(TICKET)"), Term.createTerm("storeAccepted(N)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								CommUtils.outmagenta("$name | Richiesta accettata con ticket ${payloadArg(0)}!")
						}
						if( checkMsgContent( Term.createTerm("storeRejected(REASON)"), Term.createTerm("storeRejected(R)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								CommUtils.outmagenta("$name | Richiesta rifiutata per: ${payloadArg(0)}")
						}
						delay(1000) 
						 System.exit(0)  
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
				}	 
			}
		}
} 
