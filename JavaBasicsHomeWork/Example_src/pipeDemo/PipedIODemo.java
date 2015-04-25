package pipeDemo;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedIODemo {

	public static void main(String[] args) throws IOException {
		final PipedOutputStream output=new PipedOutputStream();
		final PipedInputStream input=new PipedInputStream(output);
		Thread writerThread=new Thread(new Runnable(){
			
			@Override
			public void run(){
			try{
				output.write("Hello world, pipe!".getBytes());
			}catch(IOException e){}
			}
		});
		
		Thread readerThread = new Thread(new Runnable(){
			@Override
			public void run(){
			try{
				int data=input.read();
			while(data!=-1){
				System.out.print((char)data+" ");// OUTPUT ON THE CONSOLE
				data=input.read();
			}
			}catch(IOException e){
				
			}finally {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
		});
			writerThread.start();
			readerThread.start();
	}
}
