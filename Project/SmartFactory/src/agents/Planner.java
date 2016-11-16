package agents;
import behavior.Plan;
import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.util.leap.HashMap;

public class Planner extends Agent{
	HashMap map = new HashMap();
	protected void setup(){
		 Plan behavior = new Plan();
		 addBehaviour(behavior);
		 map.put("hallo", "Testing HashMap");
		 System.out.println(map.get("hallo").toString());
	}
}
