/* Generated by AN DISI Unibo */ 
package it.unibo.nor

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

class Nor ( name: String, scope: CoroutineScope, isconfined: Boolean=false  ) : ActorBasicFsm( name, scope, confined=isconfined ){

	override fun getInitialState() : String{
		return "s0"
	}
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		//val interruptedStateTransitions = mutableListOf<Transition>()
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						delay(200) 
						CommUtils.outmagenta("$name | Starting...")
						forward("signals", "signals(true,false)" ,name ) 
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t00",targetState="operate",cond=whenDispatch("signals"))
				}	 
				state("operate") { //this:State
					action { //it:State
						if( checkMsgContent( Term.createTerm("signals(F,S)"), Term.createTerm("signals(F,S)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								CommUtils.outmagenta("$name | Ricevuto ${payloadArg(0)} e ${payloadArg(1)}")
								delay(500) 
								if(  payloadArg(0).toBoolean() == false && payloadArg(1).toBoolean() == false  
								 ){CommUtils.outmagenta("$name | Output: TRUE")
								forward("signals", "signals(R,true)" ,"controller" ) 
								}
								else
								 {CommUtils.outmagenta("$name | Output: FALSE")
								 forward("signals", "signals(R,false)" ,"controller" ) 
								 }
						}
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t01",targetState="operate",cond=whenDispatch("signals"))
				}	 
			}
		}
} 