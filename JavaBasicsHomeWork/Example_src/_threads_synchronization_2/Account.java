package _threads_synchronization_2;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {
	AtomicInteger money;
	final int MIN_ALLOWED_BALANCE;
	
	public Account(AtomicInteger money, int min_allowed_balance) {
		this.money = money;
		this.MIN_ALLOWED_BALANCE = min_allowed_balance;
	}
	
	public AtomicInteger get() {
		return money;
	}
	
	public void set(AtomicInteger x) {
		money = x;
	}
}
