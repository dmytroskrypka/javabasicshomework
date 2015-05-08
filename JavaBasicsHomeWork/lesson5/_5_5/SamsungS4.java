package _5_5;

public class SamsungS4 extends Phone {

	public SamsungS4(String number) {
		//System.out.println("SamsungS4 constructor");
		this.number = number;
		touch = true;
		hasWifi = true;
		screenSize = 5;
		
	}

	/* (non-Javadoc)
	 * @see Phone#call(java.lang.String)
	 */
	@Override
	public boolean call(String number) {
		System.out.println(this.number + " SamsungS4 class is calling to " + number);
		return super.call(number);
	}

	/* (non-Javadoc)
	 * @see Phone#sendSMS(java.lang.String, java.lang.String)
	 */
	@Override
	public void sendSMS(String number, String message) {
		System.out.println("SamsungS4 class is sending sms Hello " + message + " to " + number);	
		super.sendSMS(number, message);
	}

}
