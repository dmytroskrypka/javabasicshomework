package threads_synchronization;

public class Action extends Thread {
	Account acc; //С какого аккаунта
	int withdraw; //..�?колько �?н�?ть.
	public Action(Account acc, int withdraw) {
		this.acc = acc;
		this.withdraw = withdraw;
	}
	@Override
	public void run() {
		// Синхронизаци�? на аккаунте
		synchronized (acc) {
			// Сколько о�?таток на �?чету?
			int has = acc.get();
			// О�?таток позвол�?ет �?н�?ть нужную �?умму?
			if (has >= withdraw && has - withdraw >= acc.MIN_ALLOWED_BALANCE) {
				// У�?танавливаем новый балан�?
				acc.set(acc.get() - withdraw);
			} else if (has >= withdraw && has - withdraw < acc.MIN_ALLOWED_BALANCE){
				acc.set(acc.MIN_ALLOWED_BALANCE);
			}
		}
	}
}