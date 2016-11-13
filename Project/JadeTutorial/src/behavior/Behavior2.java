package behavior;

import jade.core.AID;
import jade.core.behaviours.*;
import jade.domain.AMSService;
import jade.domain.FIPANames.Ontology;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.lang.acl.ACLMessage;

	public class Behavior2 extends CyclicBehaviour {
		private AID[] agents = {new AID("Jose", AID.ISLOCALNAME),
				  				new AID("Chaitanya", AID.ISLOCALNAME)};
		private AMSAgentDescription [] AllAgents = null;

		public void action() {
			
			System.out.println("before try");
			try {
				SearchConstraints c = new SearchConstraints();
				c.setMaxResults ( new Long(-1) );
				AllAgents = AMSService.search( this.getAgent(), new AMSAgentDescription (), c );
		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    }
			ACLMessage msg = myAgent.receive();
					
			if (msg==null){
				ACLMessage message = new ACLMessage(ACLMessage.INFORM);
				
				 for (int i=0; i<AllAgents.length;i++){
					 System.out.println(AllAgents[i].getClass().toString());
					 System.out.println("msg To " + AllAgents[i].getName().getLocalName());
					 message.setContent("Ping");
					 message.setOntology(Ontology.SL0_ONTOLOGY);
					 //msg.addReceiver( agents[i]);
					 message.addReceiver(AllAgents[i].getName());
					 myAgent.send(message);
				 }
				 System.out.println("after send");
				//System.out.println("Message Send");
				//myAgent.doWait();
			}
			else{
				System.out.println(msg.getContent());
				//System.out.println(myAgent.getLocalName()+" receives message");
				//myAgent.doWake();
				block();

			}
			
		}
	}

