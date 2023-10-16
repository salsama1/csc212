import java.util.*;
public class phonebook {
public linkedlist<Contact> LinkListConatact; 
public linkedlist<Event> LinkListEvent;
public Scanner input=new Scanner(System.in); //check

public phonebook() {
	LinkListConatact = new linkedlist<>();
	LinkListEvent = new linkedlist<>();
}


public void searchcontact() {
	if(LinkListConatact.empty()) {
		System.out.println("list empty");
		return;
	}
	String select; // new String for switch
	int run = 0; // when run is 0 it means the user didnt input the right choice
	while(run != 1)  {
	System.out.println("Enter search criteria:\r\n"
			+ "1. Name\r\n"
			+ "2. Phone Number\r\n"
			+ "3. Email Address\r\n"
			+ "4. Address\r\n"
			+ "5. Birthday\r\n"
			+ "Enter your choice: ");
	select = input.nextLine();
	switch(select) {
		case "1": System.out.print("enter contact's name: ");    //finished case 1 for name
			String currentname =  input.nextLine();
			run = 1;
			Contact contname =  searcbyname(currentname);
			
			if(contname != null) {
				System.out.println("Contact found!");
				System.out.println(contname.toString());
			}
			else
				System.out.print("cant find contact");
			break;
			
		case "2": System.out.println("enter contact's phone"); // finished case 2 which is similar to case 1
			String currentphone =  input.nextLine();
			run = 1;
			Contact contphone = searchbyphone(currentphone);
			
			if(contphone != null) {
				System.out.println("Contact found!");
				System.out.println(contphone.toString());
			}
			else
				System.out.print("cant find contact");
			break;
			
		case "3": System.out.println("enter contact's email");
			String currentemail =  input.nextLine();
			run = 1;
			linkedlist<Contact> elist= new linkedlist<>(); // elist is the list of contacts with similar emails
			elist = searchbyeamil(currentemail);
			
			if(elist != null) {
				System.out.println("Contacts found!");
				elist.findfirst();
				while(!elist.last()) {
					System.out.println(elist.retreive().toString());
					elist.findnext();
				}
				System.out.println(elist.retreive().toString());
			}
			else
				System.out.print("cant find contact");
			break;
			
		case "4": System.out.println("enter contact's adress");
		System.out.print("4");
		String currentadress =  input.nextLine();
		run = 1;
		linkedlist<Contact> alist= new linkedlist<>();
		alist = searchbyAdress(currentadress);
		if(alist != null) {
			System.out.println("Contacts found!");
			while(!alist.last()) {
				System.out.println(alist.retreive().toString());
				alist.findnext();
			}
			System.out.println(alist.retreive().toString());
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
		linkedlist<Contact> blist= new linkedlist<>();
		
		blist = searchbyBirthday(currentbirth);
		if(blist != null) {
			System.out.println("Contacts found!");
			while(!blist.last()) {
				System.out.println(blist.retreive().toString());
				blist.findnext();
			}
			System.out.println(blist.retreive().toString());
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
	System.out.println("Welcome to the Linked Tree Phonebook!");
	do {
		System.out.print(
				"Please choose an option:\r\n"
				+ "1. Add a contact\r\n"
				+ "2. Search for a contact\r\n"
				+ "3. Delete a contact\r\n"
				+ "4. Schedule an event\r\n"
				+ "5. Print event details\r\n"
				+ "6. Print contacts by first name\r\n"
				+ "7. Print all events alphabetically\r\n"
				+ "8. Exit\r\n"
				+ "Enter your choice: ");
		 
		select=input.nextLine();

		switch(select) {
		case "1": Contact addcontacts = addcontact();
			if(addcontacts != null) {
				LinkListConatact.Insert(addcontacts);
				System.out.println("Contact added successfully!");
			}
			
			break;
			
		case "2": searchcontact();
			break;
			
		case "3": 
			if(LinkListConatact.empty()) {
				System.out.println("contact list is empty");
				break;
			}
			System.out.println("name of contact");
			String tmpname = input.nextLine();
			
			Contact tmpcontact = searcbyname(tmpname);
			
			if (tmpcontact != null) {
				delete(tmpcontact);
				delete_event(tmpcontact.getContactName());
				System.out.println("contacts deleted");
			}
			else 
				System.out.println("contact doesnt exist");
			break;
			
		case "4": 
			addevent();
			break;
			
		case "5": 
			System.out.println("Enter search criteria: ");
			System.out.println("1. contact name");
			System.out.println("2. Event tittle");
			System.out.print("Enter your choice: ");
			int number_choice = 0;
			String choice = input.nextLine();
			if(choice.equals("1") ) {
				System.out.print("Enter the contact name: ");
				number_choice = 1;
			}
			else if(choice.equals("2")) {
				System.out.print("Enter the event title: ");
				number_choice = 2;
			}
			else {
				System.out.println("wrong choice ");
				return;
			}
			String name =input.nextLine();

			print_events(name, number_choice);
			break;
			
		case "6": 
			if(LinkListConatact.empty()) {
				System.out.println("contact list is empty");
				break;
			}
			System.out.print("Enter the first name: ");
			String tmpfirst = input.nextLine();
			
			if(tmpfirst == null) 
				System.out.println("no name was entered");
			
			else
				print_first(tmpfirst);
			
			break;
			
		case "7": print_events_alpha();
			break;
			
		case "8": //print_contacts();
			run = 1;
			break;
			
		default:
			System.out.println("wrong choice");
	}
		}while(run!=1);
	System.out.println("goodbye!");
	}
	

public Contact addcontact( ) {
	System.out.print("enter the contact name: ");
	String contname = input.nextLine();
	if(searcbyname(contname)!=null) {
		 System.out.println("there is contact that have same name");
		 return null;
	}
	System.out.print("enter the contact phone number: ");
	String contphone = input.nextLine();
	if(searchbyphone(contphone)!=null) {
		 System.out.println("there is contact that have same phonenumber");
		 return null;
	}
	
	System.out.print("enter the contact email address: ");
	String contemail = input.nextLine();
	System.out.print("enter the contact addresss: ");
	String contaddress = input.nextLine();
	System.out.print("enter the contact birthday: ");
	String contbirth = input.nextLine();
	System.out.print("enter the contact notes for contact: ");
	String contnote = input.nextLine();
	
	Contact c=new Contact(contname,contphone,contemail,contaddress,contbirth,contnote);
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
			emaillist.Insert(LinkListConatact.retreive());
		}
		
			LinkListConatact.findnext();
			}
	
	if((LinkListConatact.retreive()).getEmailAddress().equalsIgnoreCase(Searchdata)) { // for last case
		emaillist.Insert(LinkListConatact.retreive());
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
			Adresslist.Insert(LinkListConatact.retreive());
		}
		
			LinkListConatact.findnext();
			}
	if((LinkListConatact.retreive()).getAddress().equalsIgnoreCase(Searchdata)) {
		Adresslist.Insert(LinkListConatact.retreive());
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
			Birthlist.Insert(LinkListConatact.retreive());
		}
		
			LinkListConatact.findnext();
			}
	
	if((LinkListConatact.retreive()).getBirthday().equalsIgnoreCase(Searchdata)) {
		Birthlist.Insert(LinkListConatact.retreive());
	}
	return Birthlist;
}

public void delete(Contact contact_to_delete) {
	LinkListConatact.findfirst();
	
	while(!LinkListConatact.last()) {
		if(LinkListConatact.retreive().getContactName().equalsIgnoreCase(contact_to_delete.getContactName())) { 
			LinkListConatact.remove();
		}
		else
			LinkListConatact.findnext();
	}
	
	if(LinkListConatact.retreive().getContactName().equalsIgnoreCase(contact_to_delete.getContactName())) {
		LinkListConatact.remove();
	}
		
}

public void delete_event(String contact_to_delete) {
	if(LinkListEvent.empty()) { // no events to delete
		return;
	}
	
	LinkListEvent.findfirst();
	
	while(!LinkListEvent.last()) { // events to delete
		if(LinkListEvent.retreive().getContactinvolved().getContactName().equals(contact_to_delete)) {
			LinkListEvent.remove();
		}
		else
			LinkListEvent.findnext();
	}
	if(LinkListEvent.retreive().getContactinvolved().getContactName().equals(contact_to_delete))
		LinkListEvent.remove();
}


public void addevent() {
	System.out.print("enter event title: ");
	String title = 	input.nextLine();
	
	if(searchevent(title)) {
		System.out.println("Event title exists: ");
		return;
	}
	
	else {
		System.out.print("Enter contact's name: ");
		String cname = 	input.nextLine();
		Contact cc = searcbyname(cname);
		if(cc == null) {
			System.out.println("no contact found with this name");
			return;
		}
		else {
			System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
			String date_time = 	input.nextLine();
			if(searchdate_time(date_time)) {
				System.out.println("date and time title exists");
				return ;
			}
			
			System.out.print("Enter event location: ");
			String location = 	input.nextLine();
			Event e= new Event(title,date_time,location,searcbyname(cname));
			LinkListEvent.Insert(e);
			System.out.println("Event scheduled successfully! ");
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

public void print_events(String t, int x) {
	int found = 0;

	if(LinkListEvent.empty()) {
		System.out.print("event is empty");
		return;
	}
	if(x == 1) {
		LinkListEvent.findfirst();
		while(!LinkListEvent.last()) {
			if(LinkListEvent.retreive().getContactinvolved().getContactName().equalsIgnoreCase(t)) {
				System.out.println("Events found!\r\n" + LinkListEvent.retreive().toString());
				found = 1;
			}
			LinkListEvent.findnext();
		}
		
		if(LinkListEvent.retreive().getContactinvolved().getContactName().equalsIgnoreCase(t)) { 
			System.out.println("Events found!\r\n" + LinkListEvent.retreive().toString());
			found = 1;
		}
		if(found == 0)
			System.out.println("no matching event found");
	}
	
	else {
		LinkListEvent.findfirst();
		while(!LinkListEvent.last()) {
			if(LinkListEvent.retreive().getTitle().equalsIgnoreCase(t)) {
				System.out.println("Event found!\r\n" + LinkListEvent.retreive().toString());
				found = 1;
			}
			LinkListEvent.findnext();
		}
		
		if(LinkListEvent.retreive().getTitle().equalsIgnoreCase(t)) {
			System.out.println("Event found!\r\n" + LinkListEvent.retreive().toString());
			found = 1;
		}
		if(found == 0)
			System.out.println("no matching events found");
	}
	
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
	int found = 0;//1
	
	LinkListConatact.findfirst();//1
	
	while(!LinkListConatact.last()) { //n
		
		if(extractfirst(LinkListConatact.retreive().getContactName()).equalsIgnoreCase(first_name)) { 
			if(found == 0) { // (n-1)
				// this if is used so the print will work only once
				System.out.println("Contacts found!");//1
				found = 1;//1
			}
			System.out.println(LinkListConatact.retreive().toString()); // 3(n-1)
		}
		LinkListConatact.findnext(); //n-1
	}
	
	if(extractfirst(LinkListConatact.retreive().getContactName()).equalsIgnoreCase(first_name)) {
		if(found == 0) { // this if is used so the print will work only once
			System.out.println("Contacts found!");
			found = 1;
		}
		System.out.println(LinkListConatact.retreive().toString());
	}
	
	if(found == 0) { // if found = 0 then there is no matching first name
		System.out.println("Contacts not found!");
	}
}
	
	public void print_events_alpha() {
		
		if(LinkListEvent.empty()) { //1
			System.out.println("no events");//1
			return;//1
		}
		LinkListEvent.findfirst(); //1
		 
			while(!LinkListEvent.last()) { // n times
				System.out.println(LinkListEvent.retreive().toString()); //3(n-1)
				LinkListEvent.findnext(); //n-1
			}
			System.out.println(LinkListEvent.retreive().toString()); // 3
	}
	//total is = 
	
	//public void print_contacts() {
		//if(LinkListConatact.empty()) {
			//System.out.print("no contacts");
			//return;
		//}
		//LinkListConatact.findfirst();

			//while(!LinkListConatact.last()) {
				//System.out.println(LinkListConatact.retreive().toString());
				//LinkListConatact.findnext();
			//}
			//System.out.println(LinkListConatact.retreive().toString());
	//}

}