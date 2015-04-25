package _Phone;

public class SamsungS4 extends Phone {

	public SamsungS4() {
		System.out.println("SamsungS4 constructor");
		
		touch = true;
		hasWifi = true;
		screenSize = 5;
	}

	/* (non-Javadoc)
	 * @see Phone#call(java.lang.String)
	 */
	@Override
	public void call(String number) {
		System.out.println("SamsungS4 class is calling " + number);
		super.call(number);
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
