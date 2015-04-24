package trains_xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="trains")
public class Trains {
	
	 @XmlElement(name="train")
	 private List<Train> trains = new ArrayList<Train>();
	 
	 
	public List<Train> getTrains() {
		return trains;
	}

	@Override
    public String toString() {
        return Arrays.deepToString(trains.toArray());
    }
	
}
