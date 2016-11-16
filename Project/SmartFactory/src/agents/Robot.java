package agents;
import behavior.Execute;
import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.WakerBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.AMSService;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class Robot extends Agent {


	
 protected void setup() {
	 DFAgentDescription description  = new DFAgentDescription();
	 ServiceDescription service = new ServiceDescription();
	 //Behavior1 behavior = new Behavior1(this,500);
	 Execute behavior = new Execute();
	 addBehaviour(behavior);
	 
	 description.setName(getAID());
	 service.setName("Robot");
	 service.addLanguages("Robot");
	 service.setType("Robot");
	 description.addServices(service);
	 try {
		DFService.register(this, description);
	} catch (FIPAException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 System.out.println("Agent Local Name " + this.getLocalName());
	 System.out.println("Agent Local Name " + this.getName());
	 System.out.println("Agent State " + this.getState());
	 System.out.println(this.getAgentState());
	 
 }

 // Put agent clean-up operations here
 protected void takeDown() {
	// Printout a dismissal message
	System.out.println("Killing" +getAID().getName());
 }
}
