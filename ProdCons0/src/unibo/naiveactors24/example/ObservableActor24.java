package unibo.naiveactors24.example;

import java.util.ArrayList;
import java.util.List;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.naiveactors24.ActorContext24;

public class ObservableActor24 extends Actor24Receiver {
	private List<ObserverActor24> observers;
	
	public ObservableActor24(String name, ActorContext24 ctx ){ 
        super(name, ctx);
        this.observers = new ArrayList<>();
    }
	
	protected void register(ObserverActor24 observer) {
		this.observers.add(observer);
	}
	
	protected void unregister(ObserverActor24 observer) {
		this.observers.remove(observer);
	}
	
	private void updateObservers(IApplMessage msg) {
		this.observers.forEach((obs) -> obs.notify(msg));
	}

	@Override
	protected void elabMsg(IApplMessage msg) throws Exception {
		super.elabMsg(msg);
		this.updateObservers(msg);
	}

}
