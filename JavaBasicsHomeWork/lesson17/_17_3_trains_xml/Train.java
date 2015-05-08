package _17_3_trains_xml;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="train")
public class Train {
	
	private String id; //attribute
	private String from;
	private String to;
	private Date date;
	private Date departure;
	
	
	public Train() {}

	public Train(String id, String from, String to, Date date,
			Date departure) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.date = date;
		this.departure = departure;
	}
	
	@XmlAttribute(name = "id")
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlElement
	public void setFrom(String from) {
		this.from = from;
	}

	@XmlElement
	public void setTo(String to) {
		this.to = to;
	}

	@XmlElement
	@XmlJavaTypeAdapter(DateAdapter.class)
	public void setDate(Date date) {
		this.date = date;
	}

	@XmlElement
	@XmlJavaTypeAdapter(TimeAdapter.class)
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	
	

	public String getId() {
		return id;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public Date getDate() {
		return date;
	}

	public Date getDeparture() {
		return departure;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", from=" + from + ", to=" + to + ", date="
				+ (new SimpleDateFormat("dd.MM.yyyy")).format(date) + ", departure=" 
				+ (new SimpleDateFormat("HH:mm")).format(departure) + "]"+ System.getProperty("line.separator");
	}
	
	
	
	
	
}
