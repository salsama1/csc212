import java.util.*;
public class phonebook {
public BST ListConatact; 
public linkedlist<Event> LinkListEvent;
public linkedlist<Event> LinkListAppointment;
public Scanner input=new Scanner(System.in); //check

public phonebook() { // big o(1) total = 2
	ListConatact = new BST();//1
	LinkListEvent = new linkedlist<>();//1
}


public void searchcontact() 
{//bigO(n)    total=5n+29   
	if(ListConatact.empty()) {//1
		System.out.println("list empty");//1
		return;//1
	}
	String select; //1
	
	System.out.print("Enter search criteria:\r\n"
			+ "1. Name\r\n"
			+ "2. Phone Number\r\n"
			+ "3. Email Address\r\n"
			+ "4. Address\r\n"
			+ "5. Birthday\r\n"
			+ "Enter your choice: ");//1
	select = input.nextLine();//1
	
	switch(select) {//1
		case "1": System.out.print("enter contact's name: ");//1           finished case 1 for name
			String currentname =  input.nextLine();//1
		
			Contact contname = ListConatact.search_name(currentname);//n
			
			if(contname != null) {//1							// if we find the name we print the details else we break
				System.out.println("Contact found!");//1
				System.out.println(contname.toString());//1
			}
			else//1
				System.out.print("cant find contact");//1
			break;//1
			
		case "2": System.out.print("enter contact's phone"); //1    finished case 2 which is similar to case 1
			String currentphone =  input.nextLine();//1
			
			Contact contphone =  ListConatact.search_phone(currentphone);//n
			
			if(contphone != null) {//1							// same as case 1
				System.out.println("Contact found!");//1
				System.out.println(contphone.toString());//1
			}
			else//1
				System.out.print("cant find contact");//1
			break;//1
			
		case "3": System.out.println("enter contact's email");//1
			String currentemail =  input.nextLine();//1
			
			ListConatact.search_email(currentemail);//n
			 
			break;//1
			
		case "4"://1
			System.out.println("enter contact's adress");//1
		String currentadress =  input.nextLine();//1
	
		ListConatact.search_address(currentadress);//n
		
			break;//1
		case "5": //1
		System.out.println("enter contact's birth");//1
		String currentbirth =  input.nextLine();//1

		ListConatact.search_birthday(currentbirth);//n
		
			break;//1
		default://1
			System.out.println("Sorry wrong number");//1
		}
	}// when user inputs wrong number
//}


public void menu() //bigO(n^3)  total=N^3+3n^2+5n+60
{
	String select;//1
	int run = 0;//1
	System.out.println("Welcome to the BST Phonebook!");//1
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
				+ "Enter your choice: ");//1
		 
		select=input.nextLine();//1

		switch(select) {//1
		case "1"://1 
			Contact addcontacts = addcontact();//n
			if(addcontacts != null) {//1
				ListConatact.insert(addcontacts);//n
					System.out.println("Contact added successfully!");//1
		

			}
			
			break;//1
			
		case "2": searchcontact();//n
			break;//1
			
		case "3": //1
			if(ListConatact.empty()) //1
			{
				System.out.println("contact list is empty");//1
				break;//1
			}
			System.out.println("name of contact");//1
			String tmpname = input.nextLine();//1
			
			Contact tmpcontact = ListConatact.search_name(tmpname);//n
			
			if (tmpcontact != null)//1 
			{
				delete(tmpcontact);//n^2
				delete_event(tmpcontact.getContactName());//n^2
				System.out.println("contacts and their events deleted");//1
			}
			else //1
				System.out.println("contact doesnt exist");//1
			break;//1
			
		case "4": //1
			addevent();//n
			break;//1
			
		case "5": //1
			System.out.println("Enter search criteria: ");//1
			System.out.println("1. contact name");//1
			System.out.println("2. Event tittle");//1
			System.out.print("Enter your choice: ");//1
			int number_choice = 0;//1
			String choice = input.nextLine();//1
			if(choice.equals("1") ) {//1
				System.out.print("Enter the contact name: ");//1
				number_choice = 1;//1
			}
			else if(choice.equals("2"))//1
			{
				System.out.print("Enter the event title: ");//1
				number_choice = 2;//1
			}
			else //1
				{
				System.out.println("wrong choice ");//1
				break;//1

			}
			String name =input.nextLine();//1

			print_events(name, number_choice);//n
			
		case "6": //1
			if(ListConatact.empty()) //1
			{
				System.out.println("contact list is empty");//1
				break;//1
			}
			System.out.print("Enter the first name: ");//1
			String tmpfirst = input.nextLine();//1
			
			if(tmpfirst == null)//1 
				System.out.println("no name was entered");//1
			
			else//1
				ListConatact.search_firstname(tmpfirst);//n^2
			
			break;//1
			
		case "7"://1 
			print_events_alpha();//n
			break;//1
			
		case "8"://1
			run = 1;//1
			break;//1
			
		default://1
			System.out.println("wrong choice");//1
	}
		}while(run!=1);//n
	System.out.println("goodbye!");//1
	}
	

public Contact addcontact( ) {//bigO(n)    total=2n+18  
	System.out.print("enter the contact name: ");//1
	String contname = input.nextLine();//1
	if(ListConatact.search_name(contname)!=null) {//n
		 System.out.println("there is contact that have same name");//1
		 return null;//1
	}
	System.out.print("enter the contact phone number: ");//1
	String contphone = input.nextLine();//1
	if(ListConatact.search_phone(contphone)!=null) {//n
		 System.out.println("there is contact that have same phonenumber");//1
		 return null;//1
	}
	
	System.out.print("enter the contact email address: ");//1
	String contemail = input.nextLine();//1
	System.out.print("enter the contact addresss: ");//1
	String contaddress = input.nextLine();//1
	System.out.print("enter the contact birthday: ");//1
	String contbirth = input.nextLine();//1
	System.out.print("enter the contact notes for contact: ");//1
	String contnote = input.nextLine();//1
	
	Contact c=new Contact(contname,contphone,contemail,contaddress,contbirth,contnote);//1
	
	return c;//1
}



public void delete(Contact contact_to_delete){ //bigO(n^2)   n^2+5n+3 

	//deletes contacts with the same name as user inputs
	if(ListConatact.findkey(contact_to_delete.getContactName())) //n
		ListConatact.removeKey(contact_to_delete.getContactName()); //n
	return;
		
}

public void delete_event(String contact_to_delete){ //bigO(n^2)    total=n^2+4n+4

	if(LinkListEvent.empty())//1 
	{ // no events to delete
		return;//1
	}
	
	LinkListEvent.findfirst();//1
	
	while(!LinkListEvent.last()) //n
	{ // events to delete
		if(LinkListEvent.retreive().getContactinvolved().getContactName().equals(contact_to_delete))//n
		{
			LinkListEvent.remove();//n*n
		}
		else//n
			LinkListEvent.findnext();//n
	}
	if(LinkListEvent.retreive().getContactinvolved().getContactName().equals(contact_to_delete))//1
		LinkListEvent.remove();//n
}


public void addevent() //bigO(n)   total=4n+18
{
	System.out.print("enter event title: ");//1
	String title = 	input.nextLine();//1
	
	if(searchevent(title)) //n
	{
		System.out.println("Event title exists: ");//1
		return;//1
	}
	
	else//1 
	{
		System.out.print("Enter contact's name: ");//1
		String cname = 	input.nextLine();//1
		Contact cc = ListConatact.search_name(cname);//n
		if(cc == null) //1
		{
			System.out.println("no contact found with this name");//1
			return;//1
		}
		else //1
		{
			System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");//1
			String date_time = 	input.nextLine();//1
			if(searchdate_time(date_time)) //n
			{
				System.out.println("date and time title exists");//1
				return ;//1
			}
			
			System.out.print("Enter event location: ");//1
			String location = 	input.nextLine();//1
			Event e= new Event(title,date_time,location,ListConatact.search_name(cname));//1
			LinkListEvent.Insert(e);//n
			System.out.println("Event scheduled successfully! ");//1
		}


	}
	
}


public boolean searchevent(String title) //bigO(n) total=3n+8
{
	
		if(LinkListEvent.empty()) //1
		{
			return false;//1
		}
		
		LinkListEvent.findfirst();//1
		
		while(!LinkListEvent.last())//n+1
		{
			if((LinkListEvent.retreive()).getTitle().equalsIgnoreCase(title))//n
				return true;//1
			LinkListEvent.findnext();//n
			}
		
		if(LinkListEvent.retreive().getTitle().equalsIgnoreCase(title))//1 // for last case
			return true;//1
		
		return false;//1
	
}

public boolean searchdate_time(String Date_Time)//bigO(n)  total=3n+8  
{

if(LinkListEvent.empty()) //1
{
	return false;//1
}

LinkListEvent.findfirst();//1

while(!LinkListEvent.last())//n+1 
{
	if((LinkListEvent.retreive()).getDate_Time().equalsIgnoreCase(Date_Time))//n
		return true;//1
	LinkListEvent.findnext();//n
	}

if(LinkListEvent.retreive().getDate_Time().equalsIgnoreCase(Date_Time)) //1 for last case
	return true;//1

return false;//1

}

public void print_events(String t, int x) //bigO(n)      total=19+9n
{
	int found = 0;//1

	if(LinkListEvent.empty())//1
	{
		System.out.print("event is empty");//1
		return;//1
	}
	if(x == 1) //1
	{
		LinkListEvent.findfirst();//1
		while(!LinkListEvent.last()) //n+1
		{
			if(LinkListEvent.retreive().getContactinvolved().getContactName().equalsIgnoreCase(t)) //n
			{
				System.out.println("Events found!\r\n" + LinkListEvent.retreive().toString());//n
				found = 1;//n
			}
			LinkListEvent.findnext();//n
		}
		
		if(LinkListEvent.retreive().getContactinvolved().getContactName().equalsIgnoreCase(t))//1 
		{ 
			System.out.println("Events found!\r\n" + LinkListEvent.retreive().toString());//1
			found = 1;//1
		}
		if(found == 0)//1
			System.out.println("no matching event found");//1
	}
	
	else //1
	{
		LinkListEvent.findfirst();//1
		while(!LinkListEvent.last()) //n+1
		{
			if(LinkListEvent.retreive().getTitle().equalsIgnoreCase(t)) //n
			{
				System.out.println("Event found!\r\n" + LinkListEvent.retreive().toString());//n
				found = 1;//n
			}
			LinkListEvent.findnext();//n
		}
		
		if(LinkListEvent.retreive().getTitle().equalsIgnoreCase(t)) //1
		{
			System.out.println("Event found!\r\n" + LinkListEvent.retreive().toString());//1
			found = 1;//1
		}
		if(found == 0)//1
			System.out.println("no matching events found");//1
	}
	
}



public String extractfirst(String fullname) //    bigO(n) total=5n+5
{ // this method is to extract each first name form the list of contact
	
	int index = 0;//1
    char currentChar = fullname.charAt(index);//1
    String firstname = "";//1

    while (currentChar != ' ' && index < fullname.length())//n+1
    {
        firstname += currentChar;//n
        index++;//n
        if (index < fullname.length())//n
        {
            currentChar = fullname.charAt(index);//n
        }
    }

    return firstname;//1
	
}

	public void print_events_alpha() //bigO(n) total=3n+6
	{
		
		if(LinkListEvent.empty()) //1
		{
			System.out.print("no events");//1
			return; //1
		}
		LinkListEvent.findfirst();//1
		
			while(!LinkListEvent.last()) //n+1
			{
				System.out.println(LinkListEvent.retreive().toString());//n
				LinkListEvent.findnext();//n
			}
			System.out.println(LinkListEvent.retreive().toString());//1		
			
	}
	
	/*public void print_contacts()//big(n) total=3n+6
	{
		if(ListConatact.empty())//1 
		{
			System.out.print("no contacts");//1
			return;//1
		}
		ListConatact.findfirst();//1

			while(!ListConatact.last()) //n+1
			{
				System.out.println(ListConatact.retreive().toString());//n
				ListConatact.findnext();//n
			}
			System.out.println(ListConatact.retreive().toString());//1
	}*/

}