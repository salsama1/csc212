
public class Event implements Comparable<Event>{
	private String Title;
	private String Date;
	private String Time;
	private String Location;
	private Contact Contactinvolved;
	
	
	
	public Event() {
		
	}
	public Event(String title, String date, String time, String location, Contact contactinvolved) {
		Title = title;
		Date = date;
		Time = time;
		Location = location;
		Contactinvolved = contactinvolved;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public Contact getContactinvolved() {
		return Contactinvolved;
	}
	public void setContactinvolved(Contact contactinvolved) {
		Contactinvolved = contactinvolved;
	}
	@Override
	public int compareTo(Event o) {
		return Title.compareTo(o.Title);
	}
	
	
}