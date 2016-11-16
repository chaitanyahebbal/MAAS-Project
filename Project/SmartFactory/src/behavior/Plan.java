package behavior;

import agents.Robot;
import jade.core.behaviours.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames.Ontology;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

	public class Plan extends CyclicBehaviour {

		private DFAgentDescription [] AllAgents = null;

		public void action() {
			
			SearchConstraints c = new SearchConstraints();
			c.setMaxResults ( new Long(-1) );
			DFAgentDescription descr = new DFAgentDescription();
			ServiceDescription sd = new ServiceDescription();
	        sd.setType("Robot");
	        descr.addServices(sd);
	       
			try {
				AllAgents = DFService.search( this.getAgent(), descr, c );
			} catch (FIPAException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ACLMessage msg = myAgent.receive();
					
			if (msg==null){
				ACLMessage message = new ACLMessage(ACLMessage.INFORM);
				
				 for (DFAgentDescription agent : AllAgents){
					 message.setContent("Ping");
					 message.setOntology(Ontology.SL0_ONTOLOGY);
					 message.addReceiver(agent.getName());
					 myAgent.send(message);
				 }
				//System.out.println("Message Send");
				//myAgent.doWait();
			}
			else{
				System.out.println(msg.getContent());
				//myAgent.doWake();
				block();

			}
			
		}
	}

