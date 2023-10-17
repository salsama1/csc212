
import java.util.Scanner;

public class Contact implements Comparable<Contact>{
private String ContactName;
private String PhoneNumber;
private String EmailAddress;
private String Address;
private String Birthday;
private String Note;




public int compareTo(Contact o) {//1 bigO(1)
	return ContactName.compareTo(o.ContactName);//1
	
}

public Contact(String contactName, String phoneNumber, String emailAddress, String address, String birthday, String note)//6 bigO(1) 
	{ContactName = contactName;//1
	PhoneNumber = phoneNumber;//1
	EmailAddress = emailAddress;//1
	Address = address;//1
	Birthday = birthday;//1
	Note = note;//1
}


public Contact()//6 ->  bigO(1) 
{
};



public String getContactName()//1   bigO(1)
{
	return ContactName;//1
}
public void setContactName(String contactName)//1    bigO(1)
{
	ContactName = contactName;//1
}
public String getNote()//1    bigO(1)	
{
	return Note;//1
}
public void setNote(String note) //1    bigO(1)
{
	Note = note;//1
}
public String getEmailAddress()//1    bigO(1) 
{
	return EmailAddress;//1
}
public void setEmailAddress(String emailAddress) {//1   bigO(1)
	EmailAddress = emailAddress;//1
}
public String getAddress() //1 bigO(1)
{
	return Address;//1
}
public void setAddress(String address)//1 bigO(1) 
{
	Address = address;//1
}
public String getBirthday() //1 bigO(1)
{
	return Birthday;//1
}
public void setBirthday(String birthday) //1 bigO(1)
{
	Birthday = birthday;//1
}
public String getPhoneNumber()//1 bigO(1)
{
	return PhoneNumber;//1
}
public void setPhoneNumber(String phoneNumber)//1 bigO(1)
{
	PhoneNumber = phoneNumber;//1
}

@Override // made to string method here
public String toString() {//1 bigO(1)
	return "Name:" + ContactName + "\n PhoneNumber:" + PhoneNumber + "\n EmailAddress:" + EmailAddress
			+ "\n Address:" + Address + "\n Birthday:" + Birthday + "\n Note:" + Note;//1
}
 


}