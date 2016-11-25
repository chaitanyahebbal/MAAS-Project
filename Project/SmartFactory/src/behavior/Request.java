package behavior;

import java.io.IOException;
import java.io.Serializable;

import objects.ClientOrder;
import jade.core.behaviours.SimpleBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPANames.Ontology;
import jade.lang.acl.ACLMessage;

public class Request extends SimpleBehaviour {
	
	private DFAgentDescription [] Agents = null;
	public ClientOrder clientreq;

	public void action() {
		DFAgentDescription descr = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		SearchConstraints c = new SearchConstraints();
		ACLMessage msg = myAgent.receive();

		c.setMaxResults ( new Long(-1) );			
        sd.setType("Planner");
        descr.addServices(sd);

		try {
			Agents = DFService.search( this.getAgent(), descr, c );
			System.out.println("Successfull Service");
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (msg==null){

			ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
			 for (DFAgentDescription agent : Agents){
				 //message.setContent("Ping");
				 message.setSender(myAgent.getAID());

				 try{
					  message.setContentObject(clientreq);
				 }
				 catch(IOException e){
					 System.err.println("Error");
					 e.printStackTrace();
				 }

				 message.setOntology(Ontology.SL0_ONTOLOGY);
				 message.addReceiver(agent.getName());
				 myAgent.send(message);
			 }
			//myAgent.doWait();
		}
		else{
	        System.out.println("else");
			System.out.println(msg.getContent());
			//myAgent.doWake();
			block();

		}
		
	}
	
	public boolean done(){
		return true;
	}	
}
