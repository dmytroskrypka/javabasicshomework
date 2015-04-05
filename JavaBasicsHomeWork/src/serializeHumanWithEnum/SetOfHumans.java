package serializeHumanWithEnum;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

public class SetOfHumans {
	HashSet<Human> humans;
	String name;
	
	public SetOfHumans(String name) {
		humans = new HashSet<Human>();
		this.name = name;
	}
	
	public void Show(){
		System.out.println(this.name);
		for(Human human: humans){
			System.out.println(human.toString());
		}
	}
	
	public void SaveToFile(String filename) {
		ObjectOutputStream oos = null;
		try {
			oos= new ObjectOutputStream(new FileOutputStream(filename));
			for(Human human: humans){
					oos.writeObject(human);
			}
		}catch (IOException ex) {
		} finally {
		            if (oos != null) {
		                try {
		                	//oos.flush();
		                	oos.close();
		                } catch (Exception e) {}
		            }
		        }
	}
	
	public void GetFromFile(String filename) {
		ObjectInputStream ois = null;
		Human human = null;
		try {
			ois= new ObjectInputStream(new FileInputStream(filename));
			while ((human = (Human) ois.readObject()) !=null ){
				this.humans.add(human);
			}
		}catch (ClassNotFoundException ex) {
			System.out.println("wrong class in the file");
		}catch (FileNotFoundException ex){
			System.out.println("file not found");
		}catch (Exception ex){	
		} finally {
		            if (ois != null) {
		                try {
		                	ois.close();
		                } catch (Exception e) {}
		            }
		        }
	}
	
	public void WriteToTxtFile(String filename) {
        BufferedWriter bufferedWriter = null;
        try {
 
        	bufferedWriter = new BufferedWriter(new FileWriter(new File(filename)));
 
            // Write the lines one by one
            for (Human human: humans) {
                bufferedWriter.write(human.toString());
                bufferedWriter.newLine();
            }
 
        } catch (IOException e) {
            System.err.println("Error writing the file : ");
            e.printStackTrace();
        } finally {
 
            if (bufferedWriter != null) {
                try {
                	bufferedWriter.flush();
                    bufferedWriter.close();
                    //fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

	}
	
	public void writeFromFile(String filename) {
		try {
			FileInputStream fis= new FileInputStream(filename);
			ObjectInputStream oin= new ObjectInputStream(fis);
				try {
					while (oin.available()>0){
						humans.add((Human) oin.readObject());
					}
				} finally {
					oin.close();
				}
			
		}catch (IOException| ClassNotFoundException ex) {}
	}
	
}
