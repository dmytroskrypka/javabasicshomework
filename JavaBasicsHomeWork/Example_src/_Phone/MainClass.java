package _Phone;

public class MainClass {

	public static void main(String[] args) {
		// Phone p = new Phone(); ошибка т.к. класс абстрактный
		
		Nokia3310 nokia = new Nokia3310();
		System.out.println("Nokia3310 screent size: " + nokia.getScreenSize());
		nokia.call("123-45-67");
		nokia.sendSMS("567-78-89", "text message");
		
		System.out.println("----------------------------------");
		
		IPhone iphone = new IPhone();
		System.out.println("IPhone screent size: " + iphone.getScreenSize());
		iphone.call("123-45-67");
		iphone.sendSMS("567-78-89", "text message");
		
		System.out.println("----------------------------------");
		
		IPhone5 iphone5 = new IPhone5();
		System.out.println("IPhone screent size: " + iphone5.getScreenSize());
		iphone5.call("123-45-67");
		iphone5.sendSMS("567-78-89", "text message");
		iphone5.call("123-45-67");
		iphone5.sendSMS("567-78-89", "text message");
		
		System.out.println("----------------------------------");
		
		SamsungS4 samsungs4 = new SamsungS4();
		System.out.println("SamsungS4 screent size: " + samsungs4.getScreenSize());
		samsungs4.call("123-45-67");
		samsungs4.sendSMS("567-78-89", "text message");
		samsungs4.call("123-45-67");
		samsungs4.sendSMS("567-78-89", "text message");
		
		System.out.println("----------------------------------");
		System.out.println("Iphone made " + iphone.numberOfCalls + ((iphone.numberOfCalls==1)?" call":" calls"));
		System.out.println("Iphone 5 made " + iphone5.numberOfCalls + ((iphone5.numberOfCalls==1)?" call":" calls"));
		System.out.println("Samsung S4 made " + samsungs4.numberOfCalls + ((samsungs4.numberOfCalls==1)?" call":" calls"));
		
	}
}
