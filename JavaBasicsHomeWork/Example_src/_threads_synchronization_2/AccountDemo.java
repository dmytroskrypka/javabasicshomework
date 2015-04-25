package _threads_synchronization_2;

import java.util.concurrent.atomic.AtomicInteger;

public class AccountDemo {
	public static void main(String[] args) throws Exception {
		Account acc = new Account(new AtomicInteger(1000),100);
		for (int i = 0; i < 100; i++) {
			Action act = new Action(acc, 9);
			act.start();
		}
		Thread.sleep(5000);
		System.out.println(acc.get());
	}
}
