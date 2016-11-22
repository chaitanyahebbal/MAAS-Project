package agents;
import objects.ClientOrder;
import behavior.Plan;
import behavior.Request;
import jade.core.Agent;

public class ClientRequest extends Agent{

	
	protected void setup() {
		Request behavior = new Request();
		Object[] args = getArguments();
		int[] objs = new int[3];
		String n = (String) args[0];

		for (int i=1; i<4; i++){
			objs[i-1] = Integer.parseInt(args[i].toString());
		}

		behavior.clientreq = new ClientOrder(n,objs);

		addBehaviour(behavior);
	}
	protected void takeDown(){
		
	}
}
