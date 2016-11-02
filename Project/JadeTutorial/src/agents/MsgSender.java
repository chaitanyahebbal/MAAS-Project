package agents;
import behavior.Behavior2;
import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.util.leap.HashMap;

public class MsgSender extends Agent{
	HashMap map = new HashMap();
	protected void setup(){
		 Behavior2 behavior = new Behavior2();
		 addBehaviour(behavior);
		 map.put("hallo", "Testing HashMap");
		 System.out.println(map.get("hallo").toString());
	}
}
