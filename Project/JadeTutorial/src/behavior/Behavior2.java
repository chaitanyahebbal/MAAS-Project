package behavior;

import jade.core.AID;
import jade.core.behaviours.*;
import jade.domain.FIPANames.Ontology;
import jade.lang.acl.ACLMessage;

	public class Behavior2 extends CyclicBehaviour {
		private AID[] agents = {new AID("Jose", AID.ISLOCALNAME),
				  				new AID("Chaitanya", AID.ISLOCALNAME)};		
		public void action() {
			ACLMessage msg = myAgent.receive();
					
			if (msg==null){
				ACLMessage message = new ACLMessage(ACLMessage.CFP);
				message.addReceiver(agents[0]);
				message.setOntology(Ontology.SL0_ONTOLOGY);
				message.setContent("To " + agents[0].getLocalName());
				myAgent.send(message);
				//System.out.println("Message Send");
				//myAgent.doWait();
			}
			else{
				//System.out.println(msg.getContent());
				//System.out.println(myAgent.getLocalName()+" receives message");
				//myAgent.doWake();
				block();

			}
			
		}
	}

