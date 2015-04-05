package _HW_5_1_3;


/**
 * @author edmiskr
 *
 */
public class Phone {
	
	protected static Phone[] addressBook;
	protected static int counter = 0;	
	
	protected String number;
	protected boolean touch;
	protected boolean hasWifi;
	protected int screenSize;
	protected int numberOfCalls;
	protected int numberOfSMS;
	
	
	public Phone() {
		//try to increase the array size by 1 every time new Phone object is created.
			if(counter>0){
				Phone[] a = new Phone[++counter];
				System.arraycopy(addressBook, 0, a, 0, addressBook.length);	
				addressBook = a;
				addressBook[addressBook.length-1] = this;
			} else {
				addressBook = new Phone[++counter];
				addressBook[0] = this;
			}
	}
	
	public boolean isTouch() {
		return touch;
	}
	
	public boolean isHasWifi() {
		return hasWifi;
	}
	
	public int getScreenSize() {
		return screenSize;
	}
	
	/**
	 * @return the numberOfCalls
	 */
	public int getNumberOfCalls() {
		return numberOfCalls;
	}

	/**
	 * @return the numberOfSMS
	 */
	public int getNumberOfSMS() {
		return numberOfSMS;
	}

	//search for the number in Phone.addressbook and call method answer from the object with respective number
	public boolean call(String number) { 
		for(Phone a:addressBook) {
			if (a.number == number) {
				a.answer(this.number);
				numberOfCalls ++;
				return true;
			}
		}
		return false;
	}
	
	public void answer(String number){
		System.out.println(this.number + " answering a call from " + number);
	}
	
	public void sendSMS(String number, String message){
		numberOfSMS++;
	}
}
