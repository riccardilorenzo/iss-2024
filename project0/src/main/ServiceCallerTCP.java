package main;

import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.BasicMsgUtil;
import unibo.basicomm23.utils.ConnectionFactory;

public class ServiceCallerTCP {
	public static void main(String[] args) {
		Interaction conn =
				ConnectionFactory.createClientSupport(ProtocolType.tcp, "130.136.113.239", "8011");
		try {
			String ans = conn.request(BasicMsgUtil.buildRequest("clientJava", "dofibo", "dofibo(22)", "servicemath")).msgContent();
			System.out.println(ans);
		} catch (Exception ex) {
			System.out.println("Errore inaspettato nella comunicazione.");
		}
	}
}
