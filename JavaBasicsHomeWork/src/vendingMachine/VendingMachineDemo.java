package vendingMachine;

public class VendingMachineDemo {
	public static final String VMDATAFILE = "vendingmachine.dat";
	

	public static void main(String[] args) {
		//VendingMachine wm = new VendingMachine(); //create new machine
		//wm.saveToFile(VMDATAFILE);
		
		VendingMachine wm = new VendingMachine(VMDATAFILE); //read existing machine data from file
		
		while (true){
	        	System.out.println("1 - see menu");
	        	System.out.println("2 - make order");
	        	System.out.println("3 - supply drinks");
	        	System.out.println("0 - exit");
	        
	        	switch (wm.getScanner().nextInt()){
		     	   	case 1:
		    			System.out.println(wm.toString());
		    			break;
		    	    	case 2:
		     	   		wm.payForOrder(wm.selectOrder());//try with lastorder
			        	break;
			        case 3:
			        	wm.addUserProductQuantity();
			        	break;
			        case 0:
			    		System.out.println("Have a nice day!");
			    		wm.saveToFile(VMDATAFILE);
			        	return;
			        default:
			        	System.out.println("Input mismatch, please try again");
	        	}
		}
	}

}
