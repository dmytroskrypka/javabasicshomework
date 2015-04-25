package json_xml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

import com.google.gson.*;

public class JSONDemo {

	public static void main(String[] args) throws IOException {
		String result = readFile(JSONDemo.class.getResource("resources/json.jsn").getFile().substring(1));
		//InputStream in = JSONDemo.class.getResourceAsStream("resources/json.jsn");
		//System.out.println(in!=null); 
		System.out.println(JSONDemo.class.getResource("resources/json.jsn").getPath()); 
		
		Gson gson = new GsonBuilder().create();
		MyJSON myjson = (MyJSON) gson.fromJson(result, MyJSON.class);
		System.out.println(myjson.name);
		System.out.println(myjson.phones[1]);
				
	}
	
	static String readFile(String path) throws IOException {
		  byte[] encoded = Files.readAllBytes(Paths.get(path));
		  return new String(encoded, "UTF-8");
	}

}
