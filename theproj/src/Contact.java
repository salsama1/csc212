
import java.util.Scanner;

public class Contact implements Comparable<Contact>{
private String ContactName;
private String PhoneNumber;
private String EmailAddress;
private String Address;
private String Birthday;
private String Note;




public int compareTo(Contact o) {
	return ContactName.compareTo(o.ContactName);
	
}

public Contact(String contactName, String phoneNumber, String emailAddress, String address, String birthday, String note) {
	ContactName = contactName;
	PhoneNumber = phoneNumber;
	EmailAddress = emailAddress;
	Address = address;
	Birthday = birthday;
	Note = note;
}


public Contact() {};



public String getContactName() {
	return ContactName;
}
public void setContactName(String contactName) {
	ContactName = contactName;
}
public String getNote() {
	return Note;
}
public void setNote(String note) {
	Note = note;
}
public String getEmailAddress() {
	return EmailAddress;
}
public void setEmailAddress(String emailAddress) {
	EmailAddress = emailAddress;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getBirthday() {
	return Birthday;
}
public void setBirthday(String birthday) {
	Birthday = birthday;
}
public String getPhoneNumber() {
	return PhoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	PhoneNumber = phoneNumber;
}

@Override // made to string method here
public String toString() {
	return "Name:" + ContactName + "\n PhoneNumber:" + PhoneNumber + "\n EmailAddress:" + EmailAddress
			+ "\n Address:" + Address + "\n Birthday:" + Birthday + "\n Note:" + Note;
}
 


}