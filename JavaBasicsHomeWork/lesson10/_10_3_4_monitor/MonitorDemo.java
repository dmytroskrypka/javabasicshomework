package _10_3_4_monitor;


public class MonitorDemo {
	public static void main(String[] args) {
		String[] list = {"c:\\Users\\edmiskr\\Documents\\Programming\\output\\1.txt",
				"c:\\Users\\edmiskr\\Documents\\Programming\\output\\2.txt",
				"c:\\Users\\edmiskr\\Documents\\Programming\\output\\3.txt"};
		
		
		Monitor m = new Monitor(list, new FileEvent());
		m.startMonitoringFile();
	}
}