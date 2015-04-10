package dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class Dictionary {
	private HashMap<String, String> dictionary;
	private static final String FILENAME = "D:\\Java\\workspace\\Lessons\\src\\dictionary\\dictionary.txt";
	
	
	public Dictionary() {
		this.dictionary = new HashMap<String, String>();
		try {
			this.readMap();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getFilename() {
		return FILENAME;
	}

	public HashMap<String, String> getDictionary() {
		return dictionary;
	}
	
	public String translate(String sentence){
		StringBuilder sb = new StringBuilder("");
		for(String word: sentence.split(" ")){
			sb.append(translateWord(word));
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public String translateWord(String word){
		//add checks here;
		return this.dictionary.get(word)!=null ? this.dictionary.get(word): word;
	}
	
	private void readMap() throws FileNotFoundException{
		String line;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(getFilename()));
		try {
			while((line = bufferedReader.readLine()) != null) {
				this.dictionary.put(line.split(":",2)[0], line.split(":",2)[1]);
            }    

        } catch(IOException ex) {
            System.out.println(
                "Error reading file '" + getFilename() + "'");                   
        } finally{
        	 try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }

	}
}
