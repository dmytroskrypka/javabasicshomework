package _10_3_4_monitor;

public class FileEvent implements IFileEvent {
	@Override
	public void onFileAdded(String s) {
		System.out.println("File added: " + s);
	}
}
