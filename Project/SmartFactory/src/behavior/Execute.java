package behavior;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
/*
public class Behavior1 extends TickerBehaviour {

	public Behavior1(Agent a, int b){
		super(a,b);
	}
	public void onTick() {
		ACLMessage msg = myAgent.receive();
		if (msg != null) {
			//System.out.println("Message Received");
			//System.out.println(msg.getContent());
			ACLMessage reply = msg.createReply();
			reply.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
			reply.setContent("Accepted");
			reply.addReceiver(msg.getSender());
			myAgent.send(reply);
			//reply.setSender(s)
		}	
	}
}
*/
public class Execute extends CyclicBehaviour {
	
	private int step=0;

	public void action() {
		ACLMessage msg = myAgent.receive();
		if (msg != null) {
			//System.out.println("Message Received");
			//System.out.println(msg.getContent());
			//System.out.println(myAgent.getLocalName()+" receives message");
			ACLMessage reply = msg.createReply();
			reply.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
			reply.setContent("Accepted");
			reply.addReceiver(msg.getSender());
			myAgent.send(reply);
			//System.out.println(myAgent.getLocalName()+" sends message");
			//reply.setSender(s)
		}	

		
		switch (step) {
		case 0:
		// perform operation X
		step++;
		if (msg!=null){
			System.out.println(msg.getPerformative());
		}
		break;
		case 1:
		// perform operation Y
		step++;
		if (msg!=null){
			System.out.println(msg.getPerformative());
		}
		break;
		case 2:
		// perform operation Z			
		step++;
		if (msg!=null){
			System.out.println(msg.getPerformative());
		}
		break;
		}
		
	}
}