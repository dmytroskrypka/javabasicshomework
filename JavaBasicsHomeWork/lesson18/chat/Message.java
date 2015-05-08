package chat;

import java.io.*;
import java.util.Date;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Date date = new Date();
	public String from;
	public String to;
	public boolean isFile;
	public transient String text;
	public transient String path;
	
	@Override
	public String toString() {
		return new StringBuilder()
			.append("[")
			.append(date.toString())
			.append(", From: ")
			.append(from)
			.append(", To: ")
			.append(to)
			.append("] ")
			.append(text)
			.toString();
	}
	
	public void writeToStream(OutputStream out)
		throws IOException
	{
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bs);
		try {
			os.writeObject(this);
			
			if ( ! isFile) {
				os.writeUTF(text);
			} else {
				// write file content
				writeFileToStream(os);
			}
		} finally {
			os.flush();
			os.close();
		}
		
		byte[] packet = bs.toByteArray();
		
		DataOutputStream ds = new DataOutputStream(out);
		ds.writeInt(packet.length);
		ds.write(packet);
		ds.flush();
	}
	
	public void writeFileToStream(OutputStream os) throws IOException{
		 File file = new File(path);
		    // Get the size of the file
		    long length = file.length();
		    if (length > Integer.MAX_VALUE) {
		        System.out.println("File is too large.");
		    }
		    byte[] bytes = new byte[(int) length];
		    FileInputStream fis = new FileInputStream(file);
		    BufferedInputStream bis = new BufferedInputStream(fis);
		    BufferedOutputStream out = new BufferedOutputStream(os);

		    int count;

		    while ((count = bis.read(bytes)) > 0) {
		        out.write(bytes, 0, count);
		    }

		    out.flush();
		    out.close();
		    fis.close();
		    bis.close();
	}
	
	public static Message readFromStream(InputStream in) 
		throws IOException, ClassNotFoundException
	{
		if (in.available() <= 0)
			return null;
		
		DataInputStream ds = new DataInputStream(in);
		int len = ds.readInt();
		byte[] packet = new byte[len];
		ds.read(packet);
		
		ByteArrayInputStream bs = new ByteArrayInputStream(packet);
		ObjectInputStream os = new ObjectInputStream(bs);
		try {
			Message msg = (Message) os.readObject();
			if ( ! msg.isFile) {
				msg.text = (String) os.readUTF();
			} else {
				// read file content
				msg.path = "d:\\received.aaa";
				saveFileFromStream(os, msg.path);
				msg.text = "File transfer";
			}
			
			return msg;
		} finally {
			os.close();
		}
	}
	
	public static void saveFileFromStream(InputStream is, String path) throws IOException{
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[] bytes = new byte[1024];

	    int count;

	    while ((count = is.read(bytes)) > 0) {
	        bos.write(bytes, 0, count);
	    }
	    bos.flush();
	    bos.close();
	}
}
