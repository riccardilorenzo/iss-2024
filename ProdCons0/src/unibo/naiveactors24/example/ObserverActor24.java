package unibo.naiveactors24.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.utils.CommUtils;
import unibo.naiveactors24.ActorBasic24;
import unibo.naiveactors24.ActorContext24;

public class ObserverActor24 extends ActorBasic24 {
	private List<ObserverActor24> observers;
	private BufferedWriter bw;
	private FileWriter fw;
	
	public ObserverActor24(String name, ActorContext24 ctx) {
		super(name, ctx);
		this.observers = new ArrayList<>();
		try {
			this.fw = new FileWriter(new File("obsloggerLog.txt"), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void updateResource(String s) {
		for (ObserverActor24 obs : observers)
			obs.msgQueue.add(CommUtils.buildDispatch(name, "update", s, obs.getName()));
	}
	
	public void register(ObserverActor24 observed) {
		observed.observers.add(this);
	}
	
	public void unregister(ObserverActor24 observed) {
		observed.observers.remove(this);
	}

	@Override
	protected void elabMsg(IApplMessage msg) throws Exception {
		if (msg.isDispatch() && msg.msgId().equals("update")) {
			CommUtils.outgreen(name + " | recUpdate " + msg.msgContent() + " " + Thread.currentThread().getName());
			if (this.getName().equals("obslogger")) {
				CommUtils.outcyan(name + " | log " + msg.msgContent() + " " + Thread.currentThread().getName());
				bw = new BufferedWriter(this.fw);
				bw.append(msg.msgReceiver() + " | " + msg.msgContent() + "\n");
				bw.close();
			}
		}

	}

}
