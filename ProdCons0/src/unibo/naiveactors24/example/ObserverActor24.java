package unibo.naiveactors24.example;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.utils.CommUtils;
import unibo.naiveactors24.ActorContext24;

public class ObserverActor24 extends Actor24Sender {
	private ObservableActor24 observed;
	
	public ObserverActor24(String name, ActorContext24 ctx) {
		super(name, ctx);
	}
	
	public ObserverActor24(String name, ActorContext24 ctx, ObservableActor24 observed){ 
        this(name, ctx);
        this.observed = observed;
        this.observed.register(this);
    }
	
	public void observe(ObservableActor24 observable) {
		if (this.observed != null)
			this.observed.unregister(this);
		this.observed = observable;
		observable.register(this);
	}
	
	protected void notify(IApplMessage msg) {
		CommUtils.outcyan(this.getName() + " | Received update from observed (" + this.observed + "): " + msg.msgContent());
	}

}
