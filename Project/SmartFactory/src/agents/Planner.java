package agents;
import behavior.Execute;
import behavior.Plan;
import jade.core.Agent;
import jade.core.AID;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.util.leap.HashMap;

public class Planner extends Agent{

	private HashMap map = new HashMap();
	protected void setup(){
		map.put("hallo", "Testing HashMap");
		System.out.println(map.get("hallo").toString());
		
		DFAgentDescription description  = new DFAgentDescription();
		ServiceDescription service = new ServiceDescription();
		//Behavior1 behavior = new Behavior1(this,500);
		Plan behavior = new Plan();
		addBehaviour(behavior);
		
		description.setName(getAID());
		service.setName("Planner");
		service.addLanguages("Planner");
		service.setType("Planner");
		description.addServices(service);

		try {
			DFService.register(this, description);
		} 
		catch (FIPAException e) {
			e.printStackTrace();
		}

	}
}
