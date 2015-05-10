package _11_3;

import java.io.*;

public class SequenceStreamDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream fistream1 = new FileInputStream("D:\\reader.txt");
		FileInputStream fistream2 = new FileInputStream("D:\\received.aaa"); 
		SequenceInputStream sistream = new SequenceInputStream(fistream1, fistream2);
		FileOutputStream fostream = new FileOutputStream("D:\\ResultSequence.txt");
		int temp;
		while( ( temp = sistream.read() ) > 0) { 
			System.out.print( (char) temp );  
			fostream.write(temp);
			} 
		fostream.close();
		sistream.close();
		fistream1.close();
		fistream2.close();
	}

}

