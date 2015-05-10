package _11_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCopyDemo {

	public static void main(String[] args) throws IOException {
		String find = "Dima";
		String replace = "Dmytro";
		BufferedReader reader = new BufferedReader(new FileReader("D:\\reader.txt"));
		PrintWriter out = new PrintWriter("D:\\result.txt");
		char[] buf = new char[find.length()];

        int r;
        do {
        	reader.mark(find.length());
            if ((r = reader.read(buf, 0, buf.length)) > 0){
            	if(find.equals(new String(buf, 0, r))){
            		out.print(replace);
            	} else {
            		out.print(buf[0]);
            		reader.reset();
            		reader.skip(1);
        		}
            }
        } while (r > 0);
		
		out.close();
		reader.close();
	}
	

}
