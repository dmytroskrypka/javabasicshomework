package save.directory.to.list;

import java.io.File;
import generics.convert.array.to.list.MyLinkedList;

public class Main {

	public static void main(String[] args) {
		MyLinkedList<String> files = new MyLinkedList<String>();
		files = getListOfFiles("c:\\Users\\edmiskr\\Documents\\Programming\\output");
		//System.out.println(files);
		files.printFirstElements(5);
	}
	
	
	public static MyLinkedList<String> getListOfFiles(String file) {
		//String file = "c:\\Users\\edmiskr\\Documents\\Programming\\output";
	        File f = new File(file);
	        MyLinkedList<String> filelist = new MyLinkedList<String>();
				if (f.exists() && f.isDirectory()) {
					filelist.setListFromArray(f.list());
				}
		return filelist;
	}

}
