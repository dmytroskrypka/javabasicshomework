package json_xml;

import java.io.IOException;
import java.nio.file.*;

import com.google.gson.*;

public class JSONDemo {

	public static void main(String[] args) throws IOException {
		String result = readFile("D:\\Java\\workspace\\Lessons\\XML\\json_xml\\resources\\json.jsn");
		
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
