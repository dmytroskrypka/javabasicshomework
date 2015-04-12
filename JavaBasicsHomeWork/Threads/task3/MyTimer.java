package task3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MyTimer {
	
	public static class TimeStampThread implements Runnable{
		
		@Override
		public void run() {
			while (!Thread.interrupted()) {
					System.out.println(LocalDateTime.now());
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						System.out.println("TimeStampTread stopped!");
						return;
					}
			}
		}
	}

	public static void main(String[] args) {
		Thread t = new Thread(new TimeStampThread());
		t.start();
		
		Scanner scanner  = new Scanner(System.in);
		if(scanner.nextLine().equals("stop")){
			 t.interrupt();
			 System.out.println("stopping time!");
	    }
		scanner.close();
	}

}
