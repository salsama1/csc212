
import java.util.*;
public class phonebook {
public linkedlist<Contact> LinkListConatact; 
public linkedlist<Event> LinkListEvent;
//int emailcount;
//int adresscount;
// int birthcount;
public Scanner input=new Scanner(System.in); //check

public phonebook() {
	LinkListConatact = new linkedlist<>();
	LinkListEvent = new linkedlist<>();
}



public void searchcontact(phonebook pbb) {
	String select; // new integer for switch
	int run = 0;
	 while(run != 1)  {
	System.out.println("Enter search criteria:\r\n"
			+ "1. Name\r\n"
			+ "2. Phone Number\r\n"
			+ "3. Email Address\r\n"
			+ "4. Address\r\n"
			+ "5. Birthday");
	System.out.print("why");
	select = input.next();
	input.nextLine();  // Consume newline 
	System.out.print(select);
	switch(select) {
		case "1": System.out.println("enter contact's name");    //finished case 1 for name
			String currentname =  input.nextLine();
			System.out.print("1");
			run = 1;
			Contact contname =  pbb.searcbyname(currentname);
			if(contname != null) {
				System.out.println("Contact found!");
				System.out.println(contname.toString());
			}
			else
				System.out.print("cant find contact");
			break;
			
		case "2": System.out.println("enter contact's phone"); // finished case 2 which is similar to case 1
			String currentphone =  input.nextLine();
			System.out.print("2");
			run = 1;
			Contact contphone = pbb.searchbyphone(currentphone);
			if(contphone != null) {
				System.out.println("Contact found!");
				System.out.println(contphone.toString());
			}
			else
				System.out.print("cant find contact");
			break;
			
		case "3": System.out.println("enter contact's email");
			String currentemail =  input.nextLine();
			System.out.print("3");
			run = 1;
			phonebook tmpbookemail = new phonebook();
			tmpbookemail.LinkListConatact = pbb.searchbyeamil(currentemail);
			if(tmpbookemail.LinkListConatact != null) {
				System.out.println("Contacts found!");
				while(!tmpbookemail.LinkListConatact.last()) {
					System.out.println(tmpbookemail.LinkListConatact.retreive().toString());
					tmpbookemail.LinkListConatact.findnext();
					//emailcount--;
				}
				System.out.println(tmpbookemail.LinkListConatact.retreive().toString());
			}
			else
				System.out.print("cant find contact");
			break;
			
		case "4": System.out.println("enter contact's adress");
		System.out.print("4");
		String currentadress =  input.nextLine();
		run = 1;
		phonebook tmpbookadress = new phonebook();
		tmpbookadress.LinkListConatact = pbb.searchbyAdress(currentadress);
		if(tmpbookadress.LinkListConatact != null) {
			System.out.println("Contacts found!");
			while(!tmpbookadress.LinkListConatact.last()) {
				System.out.println(tmpbookadress.LinkListConatact.retreive().toString());
				tmpbookadress.LinkListConatact.findnext();
				//adresscount--;
			}
			System.out.println(tmpbookadress.LinkListConatact.retreive().toString());
		}
		else
			System.out.print("cant find contact");
			break;
		case "5": 
		System.out.println("enter contact's birth");
		System.out.println("5l");
		String currentbirth =  input.nextLine();
		System.out.println(currentbirth);
		run = 1;
		phonebook tmpbookbirth = new phonebook();
		tmpbookbirth.LinkListConatact = pbb.searchbyBirthday(currentbirth);
		//System.out.println(birthcount);
		if(tmpbookbirth.LinkListConatact != null) {
			System.out.println("Contacts found!");
			while(!tmpbookbirth.LinkListConatact.last()) {
				System.out.println(tmpbookbirth.LinkListConatact.retreive().toString());
				tmpbookbirth.LinkListConatact.findnext();
				//birthcount--;
			}
			System.out.println(tmpbookbirth.LinkListConatact.retreive().toString());
		}
		else
			System.out.print("cant find contact");
			break;
		default:
			System.out.println("Sorry wrong number");
		}
	}// when user inputs wrong number
}


public void menu() {
	String select;
	int run = 0;
	phonebook pb = new phonebook();
	do {
		System.out.println("Welcome to the Linked Tree Phonebook!\r\n"
				+ "Please choose an option:\r\n"
				+ "1. Add a contact\r\n"
				+ "2. Search for a contact\r\n"
				+ "3. Delete a contact\r\n"
				+ "4. Schedule an event\r\n"
				+ "5. Print event details\r\n"
				+ "6. Print contacts by first name\r\n"
				+ "7. Print all events alphabetically\r\n"
				+ "8. Exit\r\n");
		 
		select=input.next();

		
		switch(select) {
		case "1": Contact addcontacts = addcontact(pb);
			if(addcontacts != null) 
			pb.LinkListConatact.InsertC(addcontacts);
			
			//addcontact();
			break;
			
		case "2": searchcontact(pb);
		
			break;
			
		case "3": 
			input.nextLine();  // Consume newline 
			if(pb.LinkListConatact.empty()) {
				System.out.println("contact list is empty");
				break;
			}
			System.out.println("name of contact");
			String tmpname = input.nextLine();
			
			Contact tmpcontact = pb.searcbyname(tmpname);
			
			if (tmpcontact != null) {
				pb.delete(tmpcontact);
				System.out.println("contacts deleted");
			}
			else 
				System.out.println("contact doesnt exist");
			break;
			
		case "4": Event addevent = addevent(pb);
		if(addevent != null)
			pb.LinkListEvent.InsertE(addevent);
			break;
			
		case "5":
			break;
			
		case "6": 
			System.out.println("Enter the first name:");
			input.nextLine();  // Consume newline 
			String tmpfirst = input.nextLine();
			
			if(tmpfirst == null) 
				System.out.println("no name was entered");
			
			else
				pb.print_first(tmpfirst);
			break;
			
		case "7": pb.LinkListEvent.findfirst();
			if(pb.LinkListEvent.empty()) {
				System.out.print("no events");
			}
			else {
				while(!pb.LinkListEvent.last()) {
					System.out.print(pb.LinkListEvent.retreive().toString());
					pb.LinkListEvent.findnext();
				}
				System.out.print(pb.LinkListEvent.retreive().toString());
			}
			break;
			
		case "8":
			run = 1;
			break;
			
		default:
			System.out.println("wrong choice");
	}
		}while(run!=1);
	System.out.println("goodbye!");
	}
	




//public void printallcontact() {
	//current=head;
	//while(current!=null) {
		//System.out.print(((Contact)current.data).getContactName());
		//System.out.print(((Contact)current.data).getPhoneNumber());
//	System.out.print(((Contact)current.data).getEmailAddress());
//System.out.print(((Contact)current.data).getAddress());
//System.out.print(((Contact)current.data).getBirthday());
//System.out.println(((Contact)current.data).getNote());

//current=current.next;
//}
//}

public Contact addcontact(phonebook pb) {
	//int truth = 0;
	input.nextLine();
	System.out.println("enter the contact name");
	String contname = input.nextLine();
	if(pb.searcbyname(contname)!=null) {
		 System.out.println("there is contact that have same name");
		 return null;
	}
	System.out.println("enter the contact phone number");
	String contphone = input.nextLine();
	if(pb.searchbyphone(contphone)!=null) {
		 System.out.println("there is contact that have same phonenumber");
		 return null;
	}
	
	System.out.println("enter the contact email address");
	String contemail = input.nextLine();
	System.out.println("enter the contact addresss");
	String contaddress = input.nextLine();
	System.out.println("enter the contact birthday");
	String contbirth = input.nextLine();
	System.out.println("enter the contact notes for contact");
	String contnote = input.nextLine();
	
	Contact c=new Contact(contname,contphone,contemail,contaddress,contbirth,contnote);
	//LinkListConatact.InsertC(c);
	return c;
}

public Contact searcbyname(String Searchdata) {// changed searchbyname to return Contact and to receive a string
	if(LinkListConatact.empty()) {
		return null;
	}
	LinkListConatact.findfirst();
	
	while(!LinkListConatact.last()) {
		if((LinkListConatact.retreive()).getContactName().equalsIgnoreCase(Searchdata))
			return LinkListConatact.retreive();
		LinkListConatact.findnext();
		}
	
	if(LinkListConatact.retreive().getContactName().equalsIgnoreCase(Searchdata)) // for last case
		return LinkListConatact.retreive();
	
	return null;
}


public Contact searchbyphone(String Searchdata) { // changed searchbyphone to return Contact and to receive a int
	if(LinkListConatact.empty()) {
		return null;
	}
	LinkListConatact.findfirst();
	while(!LinkListConatact.last()) {
		if((LinkListConatact.retreive()).getPhoneNumber().equals(Searchdata) )
			return LinkListConatact.retreive();
		LinkListConatact.findnext();
		}
	
	if((LinkListConatact.retreive()).getPhoneNumber().equals(Searchdata) ) // for last case
		return LinkListConatact.retreive();
	
	return null;
}

public linkedlist<Contact> searchbyeamil(String Searchdata) { // changed search by email to return a list
	if(LinkListConatact.empty()) {
		return null;
	}
	linkedlist<Contact> emaillist = new linkedlist<>(); 
	LinkListConatact.findfirst();
	
	while(!LinkListConatact.last()) {
		if(LinkListConatact.retreive().getEmailAddress().equalsIgnoreCase(Searchdata)) {
			emaillist.InsertC(LinkListConatact.retreive());
			//emailcount++;
		}
		
			LinkListConatact.findnext();
			}
	
	if((LinkListConatact.retreive()).getEmailAddress().equalsIgnoreCase(Searchdata)) { // for last case
		emaillist.InsertC(LinkListConatact.retreive());
		//emailcount++;
	}
	return emaillist;
}


public linkedlist<Contact> searchbyAdress(String Searchdata) {
	if(LinkListConatact.empty()) {
		return null;
	}
	
	linkedlist<Contact> Adresslist = new linkedlist<>(); 
	LinkListConatact.findfirst();

	
	while(!LinkListConatact.last()) {
		if((LinkListConatact.retreive()).getAddress().equalsIgnoreCase(Searchdata)) {
			Adresslist.InsertC(LinkListConatact.retreive());
			//Adresscount++;
		}
		
			LinkListConatact.findnext();
			}
	if((LinkListConatact.retreive()).getAddress().equalsIgnoreCase(Searchdata)) {
		Adresslist.InsertC(LinkListConatact.retreive());
		//Adresscount++;
	}
	return Adresslist;
}

public linkedlist<Contact> searchbyBirthday(String Searchdata) {
	if(LinkListConatact.empty()) {
		return null;
	}
	
	linkedlist<Contact> Birthlist = new linkedlist<>(); 
	LinkListConatact.findfirst();

	
	while(!LinkListConatact.last()) {
		if((LinkListConatact.retreive()).getBirthday().equalsIgnoreCase(Searchdata)) {
			Birthlist.InsertC(LinkListConatact.retreive());
			//Birthcount++;
		}
		
			LinkListConatact.findnext();
			}
	
	if((LinkListConatact.retreive()).getBirthday().equalsIgnoreCase(Searchdata)) {
		Birthlist.InsertC(LinkListConatact.retreive());
		//Birthcount++;
	}
	return Birthlist;
}

public void delete(Contact contact_to_delete) {
	LinkListConatact.findfirst();
	
	while(!LinkListConatact.last()) {
		
		if(LinkListConatact.retreive().compareTo(contact_to_delete) == 0) { 
			LinkListConatact.remove();
		}
		LinkListConatact.findnext();
	}
	
	if(LinkListConatact.retreive().compareTo(contact_to_delete) == 0) {
		LinkListConatact.remove();
	}
	
	
	if(LinkListEvent.empty()) { // no events to delete
		return;
	}
	
	LinkListEvent.findfirst();
	
	while(!LinkListEvent.last()) { // events to delete
		if(LinkListEvent.retreive().getContactinvolved().equals(contact_to_delete.getContactName())) {
			LinkListEvent.remove();
		}
		
		LinkListEvent.findnext();
	}
	if(LinkListEvent.retreive().getContactinvolved().equals(contact_to_delete.getContactName()))
		LinkListEvent.remove();
	
}

public Event addevent(phonebook pbb) {
	input.nextLine();
	System.out.println("enter event title");
	String title = 	input.nextLine();
	
	if(pbb.searchevent(title)) {
		System.out.print("Event title exists");
		return null;
	}
	
	else {
		System.out.print("Enter contact's name");
		String cname = 	input.nextLine();
		System.out.println(cname);
		Contact cc = pbb.searcbyname(cname);
		if(cc == null) {
			System.out.println(cc == null);
			System.out.print("no contact found with this name");
			return null;
		}
		else {
			System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");
			String date_time = 	input.nextLine();
			if(pbb.searchdate_time(date_time)) {
				System.out.print("date and time title exists");
				return null;
			}
			
			System.out.println("Enter event location:");
			String location = 	input.nextLine();
			Event e= new Event(title,date_time,location,pbb.searcbyname(cname));
			LinkListEvent.InsertE(e);
			return e;
		}


	}
	
	
}

public boolean searchevent(String title) {
	
		if(LinkListEvent.empty()) {
			return false;
		}
		
		LinkListEvent.findfirst();
		
		while(!LinkListEvent.last()) {
			if((LinkListEvent.retreive()).getTitle().equalsIgnoreCase(title))
				return true;
			LinkListEvent.findnext();
			}
		
		if(LinkListEvent.retreive().getTitle().equalsIgnoreCase(title)) // for last case
			return true;
		
		return false;
	
}

public boolean searchdate_time(String Date_Time) {

if(LinkListEvent.empty()) {
	return false;
}

LinkListEvent.findfirst();

while(!LinkListEvent.last()) {
	if((LinkListEvent.retreive()).getDate_Time().equalsIgnoreCase(Date_Time))
		return true;
	LinkListEvent.findnext();
	}

if(LinkListEvent.retreive().getDate_Time().equalsIgnoreCase(Date_Time)) // for last case
	return true;

return false;

}



public String extractfirst(String fullname) { // this method is to extract each first name form the list of contact
	
	int index = 0;
    char currentChar = fullname.charAt(index);
    String firstname = "";

    while (currentChar != ' ' && index < fullname.length()) {
        firstname += currentChar;
        index++;
        if (index < fullname.length()) {
            currentChar = fullname.charAt(index);
        }
    }

    return firstname;
	
}

public void print_first(String first_name) {
	int found = 0;
	if(LinkListConatact.empty()) { // check if empty
		System.out.println("no contacts are in");
		return;
	}
	
	LinkListConatact.findfirst();
	while(!LinkListConatact.last()) {
		
		if(extractfirst(LinkListConatact.retreive().getContactName()).equalsIgnoreCase(first_name)) {
			if(found == 0) { // this if is used so the print will work only once
				System.out.println("Contacts found!1");
			}
			System.out.println(LinkListConatact.retreive().toString());
			found++;
		}
		
		LinkListConatact.findnext();
	}
	if(extractfirst(LinkListConatact.retreive().getContactName()).equalsIgnoreCase(first_name)) {
		System.out.println(LinkListConatact.retreive().toString());
		found++;
	}
	
	if(found == 0) { // if found = 0 then there is no matching first name
		System.out.println("Contacts not found!2");
	}
}
	
	public void print_events() {
		
		
		
		
	}

}