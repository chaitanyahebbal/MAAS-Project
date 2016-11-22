package objects;

import java.io.Serializable;

public class ClientOrder implements Serializable{
	//bearing box 
	//bear
	//assembled bear box
	public int[] quantities;
	public String name;
	
	public ClientOrder(){
		
	}
	
	public ClientOrder(String clientName, int[] requests){
		if (requests.length == 3){
			quantities = new int[requests.length];
			System.arraycopy(requests, 0, quantities, 0, requests.length);		
			this.name = clientName;
			System.out.println("Order Generated Successfully");
		}
		else{
			System.out.println("Problem with Request");
		}
		
	}
}
