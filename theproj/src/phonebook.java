
import java.util.*;
public class phonebook {
public linkedlist<Contact> LinkListConatact; 
public linkedlist<Event> LinkListEvent;
int emailcount;
int adresscount;
int birthcount;
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
			tmpbookemail.LinkListConatact = pbb.searchbyeamil(currentemail, emailcount);
			if(emailcount != 0) {
				System.out.println("Contacts found!");
				while(emailcount != 0) {
					System.out.println(tmpbookemail.LinkListConatact.retreive().toString());
					tmpbookemail.LinkListConatact.findnext();
					emailcount--;
				}
			}
			else
				System.out.print("cant find contact");
			break;
			
		case "4": System.out.println("enter contact's adress");
		String currentadress =  input.nextLine();
		System.out.print("4");
		run = 1;
		phonebook tmpbookadress = new phonebook();
		tmpbookadress.LinkListConatact = pbb.searchbyeamil(currentadress, adresscount);
		if(adresscount != 0) {
			System.out.println("Contacts found!");
			while(adresscount != 0) {
				System.out.println(tmpbookadress.LinkListConatact.retreive().toString());
				tmpbookadress.LinkListConatact.findnext();
				adresscount--;
			}
		}
		else
			System.out.print("cant find contact");
			break;
		case "5": System.out.println("enter contact's email");
		System.out.print("5");
		String currentbirth =  input.nextLine();
		run = 1;
		phonebook tmpbookbirth = new phonebook();
		tmpbookbirth.LinkListConatact = pbb.searchbyeamil(currentbirth, birthcount);
		if(birthcount != 0) {
			System.out.println("Contacts found!");
			while(birthcount != 0) {
				System.out.println(tmpbookbirth.LinkListConatact.retreive().toString());
				tmpbookbirth.LinkListConatact.findnext();
				birthcount--;
			}
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
		case "1": 
			pb.LinkListConatact.insert(addcontact());
			
			break;
			
		case "2": searchcontact(pb);
		
			break;
			
		case "3": 
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
			
		case "4": 
			break;
			
		case "5":
			break;
			
		case "6": 
			System.out.println("Enter the first name:");
			String tmpfirst = input.nextLine();
			
			if(tmpfirst == null) 
				System.out.println("no name was entered");
			
			else
				pb.print_first(tmpfirst);
			break;
			
		case "7":
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

public Contact addcontact() {
	String garbage = input.nextLine();
	System.out.println("enter the contact name");
	String contname = input.nextLine();
	System.out.println("enter the contact phone number");
	String contphone = input.nextLine();
	System.out.println("enter the contact email address");
	String contemail = input.nextLine();
	System.out.println("enter the contact addresss");
	String contaddress = input.nextLine();
	System.out.println("enter the contact birthday");
	String contbirth = input.nextLine();
	System.out.println("enter the contact notes for contact");
	String contnote = input.nextLine();
	Contact c=new Contact(contname,contphone,contemail,contaddress,contbirth,contnote);
	return c;
}

public Contact searcbyname(String Searchdata) {// changed searchbyname to return Contact and to receive a string
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

public linkedlist<Contact> searchbyeamil(String Searchdata, int emailcount) { // changed search by email to return a list
	LinkListConatact.findfirst();
	linkedlist<Contact> emaillist = new linkedlist<>(); 
	
	while(!LinkListConatact.last()) {
		if((LinkListConatact.retreive()).getEmailAddress().equals(Searchdata)) {
			emaillist.insert(LinkListConatact.retreive());
			emailcount++;
		}
		
			LinkListConatact.findnext();
			}
	
	if((LinkListConatact.retreive()).getEmailAddress().equals(Searchdata)) { // for last case
		emaillist.insert(LinkListConatact.retreive());
		emailcount++;
	}
	return emaillist;
}


public linkedlist<Contact> searchbyAdress(String Searchdata, int Adresscount) {
	LinkListConatact.findfirst();
	linkedlist<Contact> Adresslist = new linkedlist<>(); 
	
	while(!LinkListConatact.last()) {
		if((LinkListConatact.retreive()).getAddress().equals(Searchdata)) {
			Adresslist.insert(LinkListConatact.retreive());
			Adresscount++;
		}
		
			LinkListConatact.findnext();
			}
	if((LinkListConatact.retreive()).getAddress().equals(Searchdata)) {
		Adresslist.insert(LinkListConatact.retreive());
		Adresscount++;
	}
	return Adresslist;
}

public linkedlist<Contact> searchbyBirthday(String Searchdata, int Birthcount) {
	LinkListConatact.findfirst();
	linkedlist<Contact> Birthlist = new linkedlist<>(); 
	
	while(!LinkListConatact.last()) {
		if((LinkListConatact.retreive()).getBirthday().equals(Searchdata)) {
			Birthlist.insert(LinkListConatact.retreive());
			Birthcount++;
		}
		
			LinkListConatact.findnext();
			}
	
	if((LinkListConatact.retreive()).getBirthday().equals(Searchdata)) {
		Birthlist.insert(LinkListConatact.retreive());
		Birthcount++;
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
	while(LinkListConatact.current!=null) {
		
		if(extractfirst(LinkListConatact.retreive().getContactName()).equalsIgnoreCase(first_name)) {
			if(found == 0) { // this if is used so the print will work only once
				System.out.println("Contacts found!");
			}
			System.out.println(LinkListConatact.retreive().toString());
			found++;
		}
		
		LinkListConatact.findnext();
	}
	
	if(found == 0) { // if found = 0 then there is no matching first name
		System.out.println("Contacts not found!");
	}
}

}