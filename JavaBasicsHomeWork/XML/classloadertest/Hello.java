package classloadertest;

import java.io.*;


public class Hello {

	public static void main(String[] args) {
		InputStream in = Hello.class.getResourceAsStream("json.jsn");
		System.out.println(in!=null); 
		//BufferedReader r = new BufferedReader(new InputStreamReader(in));
		
	  }
	 
	 
	}