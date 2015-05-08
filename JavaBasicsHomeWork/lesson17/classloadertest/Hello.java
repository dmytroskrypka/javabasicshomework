package classloadertest;

import java.io.*;


public class Hello {

	public static void main(String[] args) {
		InputStream in = Hello.class.getResourceAsStream("classloader.txt");
		System.out.println(in!=null); 
		//BufferedReader r = new BufferedReader(new InputStreamReader(in));
		
	  }
	 
	 
	}