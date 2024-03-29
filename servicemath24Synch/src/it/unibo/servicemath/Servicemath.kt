/* Generated by AN DISI Unibo */ 
package it.unibo.servicemath

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

class Servicemath ( name: String, scope: CoroutineScope, isconfined: Boolean=false  ) : ActorBasicFsm( name, scope, confined=isconfined ){

	override fun getInitialState() : String{
		return "s0"
	}
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		//val interruptedStateTransitions = mutableListOf<Transition>()
		 val math = MathUtils.create()
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						CommUtils.outmagenta("$name  STARTS ")
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t00",targetState="handleRequest",cond=whenRequest("dofibo"))
				}	 
				state("handleRequest") { //this:State
					action { //it:State
						val CurMsg = currentMsg  
						emit("out", "out($CurMsg)" ) 
						if( checkMsgContent( Term.createTerm("dofibo(N)"), Term.createTerm("dofibo(N)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								val N = payloadArg(0) 
								              var Sender = currentMsg.msgSender()
								CommUtils.outmagenta("$name |  N=$N ")
								 val T0 = getCurrentTime()    
										       var R = math.fibo( N.toInt() )  
											   val TF  = getDuration(T0)  
								 val SOUT="working($name,msgid(dofibo($N)),sender($Sender))"  
								CommUtils.outmagenta("$name |  $SOUT ")
								updateResourceRep( SOUT  
								)
								emit("out", "out($SOUT)" ) 
								answer("dofibo", "fibodone", "fibodone($Sender,$N,$R,$TF)"   )  
						}
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t01",targetState="handleRequest",cond=whenRequest("dofibo"))
				}	 
			}
		}
} 
