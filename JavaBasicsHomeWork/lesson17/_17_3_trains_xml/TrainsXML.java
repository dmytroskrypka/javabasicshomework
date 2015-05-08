package _17_3_trains_xml;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class TrainsXML {

	public static void main(String[] args) {
		Trains trains = new Trains();
		
		
        try {
            File file = new File("trains.xml");
            
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            trains = (Trains) unmarshaller.unmarshal(file);
            System.out.println(trains);
            
            SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
            Date earliest=new Date();
            Date latest=new Date();
            try {
	            earliest = parser.parse("15:00");
	            latest = parser.parse("19:00");
            } catch (ParseException e) {
                // Invalid date was entered
            }
            
            for(Train t: trains.getTrains()){
            	    if (t.getDeparture().after(earliest) && t.getDeparture().before(latest)) {
            	    	System.out.println(parser.format(t.getDeparture()));
            	    }
            }
            
            //trains.getTrains().add(new Train("3","Kyiv","Lviv",))
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    } 

}
