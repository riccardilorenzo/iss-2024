package unibo.naiveactors24.example;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;
import unibo.naiveactors24.ActorContext24;
 

public class MainExampleNaiveActors24 {

	
	protected void alienCaller() {
		AlienJava caller = new AlienJava("javacaller", ProtocolType.tcp, "localhost", "8123");
		caller.activate();
	}
    public void configureTheSystem(){
         
        int port1 = 8123;
        CommUtils.outblue("MainExampleTowardsActors24 CREA I CONTESTI ");
        ActorContext24 ctx1 = new ActorContext24("ctx1", "localhost", port1);
        CommUtils.outblue("MainExampleTowardsActors24 CREA GLI ATTORI ");

        ObservableActor24 a1   = new ObservableActor24("observable",ctx1);
        ObserverActor24 a2 = new ObserverActor24("a2",ctx1, a1);
        ObserverActor24 a3 = new ObserverActor24("obs1",ctx1, a1);
        ObserverActor24 a4 = new ObserverActor24("obs2",ctx1); a4.observe(a1);

        ctx1.showActorNames();
        
        a1.activateAndStart();
        a2.activateAndStart();
        a3.activateAndStart();
        a4.activateAndStart();
        
        alienCaller();
    }
    public static void main(String[] args ){
        new MainExampleNaiveActors24().configureTheSystem();
    }
}
