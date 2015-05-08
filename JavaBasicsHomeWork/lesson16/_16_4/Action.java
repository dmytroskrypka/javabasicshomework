package _16_4;

public class Action extends Thread {
	Account acc; 
	int withdraw; 
	public Action(Account acc, int withdraw) {
		this.acc = acc;
		this.withdraw = withdraw;
	}
	@Override
	public void run() {
				int old = acc.get().get();
				if(old - withdraw >= acc.MIN_ALLOWED_BALANCE){
					if(!acc.get().compareAndSet(old, old-withdraw)){
						System.out.println("sorry");
					}
				}
				
	}
}