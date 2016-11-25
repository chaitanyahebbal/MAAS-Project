package behavior;

import objects.ClientOrder;
import agents.Robot;
import jade.core.behaviours.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames.Ontology;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class Plan extends CyclicBehaviour {
	private DFAgentDescription [] AllAgents = null;
	private ClientOrder request;

	public void action() {
		DFAgentDescription descr = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		SearchConstraints c = new SearchConstraints();
		ACLMessage msg = myAgent.receive();

		c.setMaxResults ( new Long(-1) );			
	    sd.setType("Robot");
	    descr.addServices(sd);
	       
		try {
			AllAgents = DFService.search( this.getAgent(), descr, c );
		} catch (FIPAException e) {
			e.printStackTrace();
		}

				
		if (msg==null){
			ACLMessage message = new ACLMessage(ACLMessage.INFORM);
			
			for (DFAgentDescription agent : AllAgents){
				 message.setContent("Ping");
				 message.setOntology(Ontology.SL0_ONTOLOGY);
				 message.addReceiver(agent.getName());
				 myAgent.send(message);
			 }
			//myAgent.doWait();
		}
		else{

			try {
				request = (ClientOrder) msg.getContentObject();
				} catch (UnreadableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Request Received from client" + request.name);
			//myAgent.doWake();
			block();

		}
		
	}
}

