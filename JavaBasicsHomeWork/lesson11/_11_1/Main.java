package _11_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws IOException {
		String srcPath = "c:\\Users\\edmiskr\\Documents\\Programming\\output\\";
		File dir= new File(srcPath);
		File[] files = dir.listFiles();
		String newfile = "c:\\Users\\edmiskr\\Documents\\Programming\\output\\IOStream1.txt";
			
		FileWriter out = new FileWriter(newfile, false);
		
		for(File f: files){
			out.write(f.getName());
			out.write(" ");
			out.write((new Date(f.lastModified())).toString());
			out.write(" \r\n");
		}		
		out.close();		
	}
}
