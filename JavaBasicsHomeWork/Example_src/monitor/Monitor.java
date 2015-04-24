package monitor;
import java.io.File;
import java.util.Date;

public class Monitor {
	String[] fileList;
	IFileEvent event;
	
	public Monitor(String[] fileList, IFileEvent event) {
		this.fileList = fileList;
		this.event = event;
	}
	
	public void startMonitoringFile() {
		for(String file: fileList) {
	        File f = new File(file);
	        while (true) {
				if (f.exists() && f.isFile()) {
					if (event != null)
						event.onFileAdded(file);
	  					System.out.println(new Date(f.lastModified()).toString());
					break;
				}
	            delay();
	            System.out.println("Waiting...");
			}
		}
	}
	

    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted!");
            System.err.println("Thread interrupted!");
        }
    }
    

}
