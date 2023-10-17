
public class Event implements Comparable<Event>{
	private String Title;
	private String Date_Time;
	private String Location;
	private Contact Contactinvolved;
	
	
	
	
	public Event() {
		
	}
	public Event(String title, String date_Time, String location, Contact contactinvolved) {//4 bigO(1)
		Title = title;//1
		Date_Time = date_Time;//1
		Location = location;//1
		Contactinvolved = contactinvolved;//1
	}
	public String getTitle() {//1 BigO(1)
		return Title;//1
	}
	public void setTitle(String title) {//1 bigO(1)
		Title = title;//1
	}
	
	public String getDate_Time() {//1 bigO(1)
		return Date_Time;//1
	}
	public void setDate_Time(String date_Time) {//1 bigO(1)
		Date_Time = date_Time;//1
	}
	public String getLocation() {//1 bigO(1)
		return Location;//1
	}
	public void setLocation(String location) {//1 bigO(1)
		Location = location;//1
	}
	public Contact getContactinvolved() {//1 bigO(1)
		return Contactinvolved;//1
	}
	public void setContactinvolved(Contact contactinvolved) {//1 BigO(1)
		Contactinvolved = contactinvolved;//1
	}
	@Override
	public int compareTo(Event o) {//1 bigO(1)
		return Title.compareTo(o.Title);//1
	}
	
	@Override
	public String toString() {//1+1  BigO(1)
		return "Event Title:" + Title + "\n Date_Time:" + Date_Time + "\n Location:" + Location + "\n Contactinvolved:"
				+ Contactinvolved.getContactName();//1 for getContactName
		//1
	}
	
	
}