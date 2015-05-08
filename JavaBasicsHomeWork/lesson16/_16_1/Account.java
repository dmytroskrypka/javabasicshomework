package _16_1;

public class Account {
	int money;
	final int MIN_ALLOWED_BALANCE;
	
	public Account(int money, int min_allowed_balance) {
		this.money = money;
		this.MIN_ALLOWED_BALANCE = min_allowed_balance;
	}
	
	public int get() {
		return money;
	}
	
	public void set(int x) {
		money = x;
	}
}
