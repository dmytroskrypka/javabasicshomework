package _Phone;

public class IPhone extends Phone {
	protected String imei;
	
	public IPhone() {
		System.out.println("IPhone constructor");
		
		touch = true;
		hasWifi = true;
		screenSize = 3;
	}
	
	@Override
	final public void call(String number) {
		System.out.println("IPhone class is calling " + number);
		super.call(number);
	}
	
	@Override
	public void sendSMS(String number, String message) {
		super.sendSMS(number, message);
		System.out.println("IPhone class is sending sms " + message + " to " + number);	
	}
}
