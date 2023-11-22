
public class Event implements Comparable<Event>{
	private String Title;
	private String Date_Time;
	private String Location;
	private linkedlist<Contact> Contactsinvolved;
	
	
	
	
	public Event() {
		
	}
	public Event(String title, String date_Time, String location, linkedlist<Contact> contactsinvolved) {//4 bigO(1)
		Title = title;//1
		Date_Time = date_Time;//1
		Location = location;//1
		Contactsinvolved = contactsinvolved;//1
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
	public linkedlist<Contact> getContactsinvolved() {//1 bigO(1)
		return Contactsinvolved;//1
	}
	public void setContactinvolved(linkedlist<Contact> contactsinvolved) {//1 BigO(1)
		Contactsinvolved = contactsinvolved;//1
	}
	@Override
	public int compareTo(Event o) {//1 bigO(1)
		return Title.compareTo(o.Title);//1
	}
	
	@Override
	public String toString() {//1+1  BigO(1)
		String event = "Event Title:" + Title + "\n Date_Time:" + Date_Time + "\n Location:" + Location+ "\n Contactsinvolved:";
		String contact = "";
		Contactsinvolved.findfirst();
		while(!Contactsinvolved.last()) {
			contact += " " +Contactsinvolved.retreive().getContactName();//1 for getContactName
			Contactsinvolved.findnext();
		}
		contact += " " +Contactsinvolved.retreive().getContactName();//1 for getContactName
		
		return event + contact;
		
		//1
	}
	
	
}