
public class Event implements Comparable<Event>{
	private String Title;
	private String Date_Time;
	private String Location;
	private Contact Contactinvolved;
	
	
	
	@Override
	public String toString() {
		return "Event [Title=" + Title + ", Date_Time=" + Date_Time + ", Location=" + Location + ", Contactinvolved="
				+ Contactinvolved + "]";
	}
	public Event() {
		
	}
	public Event(String title, String date_Time, String location, Contact contactinvolved) {
		Title = title;
		Date_Time = date_Time;
		Location = location;
		Contactinvolved = contactinvolved;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	
	public String getDate_Time() {
		return Date_Time;
	}
	public void setDate_Time(String date_Time) {
		Date_Time = date_Time;
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