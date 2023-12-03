import java.util.*;

public class phonebook {
	public BST ListConatact;
	public linkedlist<Event> LinkListEvent;
	public linkedlist<Appointment> LinkListAppointment;
	public Scanner input = new Scanner(System.in); // check

	public phonebook() { // big o(1) total = 2
		ListConatact = new BST();// 1
		LinkListEvent = new linkedlist<>();// 1
		LinkListAppointment = new linkedlist<>();
	}

	public void searchcontact() {// bigO(n) total=5n+29
		if (ListConatact.empty()) {// 1
			System.out.println("list empty");// 1
			return;// 1
		}
		String select; // 1

		System.out.print("Enter search criteria:\r\n" + "1. Name\r\n" + "2. Phone Number\r\n" + "3. Email Address\r\n"
				+ "4. Address\r\n" + "5. Birthday\r\n" + "Enter your choice: ");// 1
		select = input.nextLine();// 1

		switch (select) {// 1
		case "1":
			System.out.print("enter contact's name: ");// 1 finished case 1 for name
			String currentname = input.nextLine();// 1

			Contact contname = ListConatact.search_name(currentname);// n

			if (contname != null) {// 1 // if we find the name we print the details else we break
				System.out.println("Contact found!");// 1
				System.out.println(contname.toString());// 1
			} else// 1
				System.out.println("cant find contact");// 1
			break;// 1

		case "2":
			System.out.print("enter contact's phone"); // 1 finished case 2 which is similar to case 1
			String currentphone = input.nextLine();// 1

			Contact contphone = ListConatact.search_phone(currentphone);// n

			if (contphone != null) {// 1 // same as case 1
				System.out.println("Contact found!");// 1
				System.out.println(contphone.toString());// 1
			} else// 1
				System.out.println("cant find contact");// 1
			break;// 1

		case "3":
			System.out.println("enter contact's email");// 1
			String currentemail = input.nextLine();// 1

			ListConatact.search_email(currentemail);// n

			break;// 1

		case "4":// 1
			System.out.println("enter contact's adress");// 1
			String currentadress = input.nextLine();// 1

			ListConatact.search_address(currentadress);// n

			break;// 1
		case "5": // 1
			System.out.println("enter contact's birth");// 1
			String currentbirth = input.nextLine();// 1

			ListConatact.search_birthday(currentbirth);// n

			break;// 1
		default:// 1
			System.out.println("Sorry wrong number");// 1
		}
	}// when user inputs wrong number
//}

	public void menu() // bigO(n^3) total=N^3+3n^2+5n+60
	{
		String select;// 1
		int run = 0;// 1
		System.out.println("Welcome to the BST Phonebook!");// 1
		do {
			System.out.print("Please choose an option:\r\n" + "1. Add a contact\r\n" + "2. Search for a contact\r\n"
					+ "3. Delete a contact\r\n" + "4. Schedule an event or Appointment\r\n"
					+ "5. Print event details\r\n" + "6. Print contacts by first name\r\n"
					+ "7. Print all events alphabetically\r\n" + "8. Exit\r\n" + "Enter your choice: ");// 1

			select = input.nextLine();// 1

			switch (select) {// 1
			case "1":// 1
				Contact addcontacts = addcontact();// n
				if (addcontacts != null) {// 1
					ListConatact.insert(addcontacts);// n
					System.out.println("Contact added successfully!");// 1
				}

				break;// 1

			case "2":
				searchcontact();// n
				break;// 1

			case "3": // 1
				if (ListConatact.empty()) // 1
				{
					System.out.println("contact list is empty");// 1
					break;// 1
				}
				System.out.println("name of contact");// 1
				String tmpname = input.nextLine();// 1

				Contact tmpcontact = ListConatact.search_name(tmpname);// n

				if (tmpcontact != null)// 1
				{
					delete(tmpcontact);// n^2
					delete_event(tmpcontact.getContactName());// n^2
					delete_Appointment(tmpcontact.getContactName());
					System.out.println("contacts and their events deleted");// 1
				} else // 1
					System.out.println("contact doesnt exist");// 1
				break;// 1

			case "4": // 1
				System.out.println("Enter add criteria: ");// 1
				System.out.println("1. event");// 1
				System.out.println("2. Appointment");// 1
				System.out.print("Enter your choice: ");// 1
				String choicee = input.nextLine();// 1
				if (choicee.equals("1")) {// 1
					addevent();
				} else if (choicee.equals("2"))// 1
				{
					addAppointment();
				} else // 1
				{
					System.out.println("wrong choice ");// 1

				}
				break;// 1

			case "5": // 1
				System.out.println("Enter search criteria: ");// 1
				System.out.println("1. contact name");// 1
				System.out.println("2. Event or Appointment title");// 1
				System.out.print("Enter your choice: ");// 1
				int number_choice = 0;// 1
				String choice = input.nextLine();// 1
				if (choice.equals("1")) {// 1
					System.out.print("Enter the contact name: ");// 1
					number_choice = 1;// 1
				} else if (choice.equals("2"))// 1
				{
					System.out.print("Enter the event or appointment title: ");// 1
					number_choice = 2;// 1
				} else // 1
				{
					System.out.println("wrong choice ");// 1
					break;// 1

				}
				String name = input.nextLine();// 1

				print_events(name, number_choice);// n
				print_appointment(name, number_choice);
				break;

			case "6": // 1
				if (ListConatact.empty()) // 1
				{
					System.out.println("contact list is empty");// 1
					break;// 1
				}
				System.out.print("Enter the first name: ");// 1
				String tmpfirst = input.nextLine();// 1

				if (tmpfirst == null)// 1
					System.out.println("no name was entered");// 1

				else// 1
					ListConatact.search_firstname(tmpfirst);// n^2

				break;// 1

			case "7":// 1
				print_events_alpha();
				print_apps_alpha();// n
				break;// 1

			case "8":// 1
				run = 1;// 1
				break;// 1

			default:// 1
				System.out.println("wrong choice");// 1
			}
		} while (run != 1);// n
		System.out.println("goodbye!");// 1
	}

	public Contact addcontact() {// bigO(n) total=2n+18
		System.out.print("enter the contact name: ");// 1
		String contname = input.nextLine();// 1
		if (ListConatact.search_name(contname) != null) {// lognn
			System.out.println("there is contact that have same name");// 1
			return null;// 1
		}
		System.out.print("enter the contact phone number: ");// 1
		String contphone = input.nextLine();// 1
		if (ListConatact.search_phone(contphone) != null) {// n
			System.out.println("there is contact that have same phonenumber");// 1
			return null;// 1
		}

		System.out.print("enter the contact email address: ");// 1
		String contemail = input.nextLine();// 1
		System.out.print("enter the contact addresss: ");// 1
		String contaddress = input.nextLine();// 1
		System.out.print("enter the contact birthday: ");// 1
		String contbirth = input.nextLine();// 1
		System.out.print("enter the contact notes for contact: ");// 1
		String contnote = input.nextLine();// 1

		Contact c = new Contact(contname, contphone, contemail, contaddress, contbirth, contnote);// 1

		return c;// 1
	}

	public void delete(Contact contact_to_delete) { // bigO(n^2) n^2+5n+3

		// deletes contacts with the same name as user inputs
		if (ListConatact.findkey(contact_to_delete.getContactName())) // n
			ListConatact.removeKey(contact_to_delete.getContactName()); // n
		return;

	}

	public void delete_event(String contact_to_delete) { // bigO(n^2) total=n^2+4n+4
		boolean deleted = false;
		boolean removed_event = false;
		if (LinkListEvent.empty())// 1
		{ // no events to delete
			return;// 1
		}

		LinkListEvent.findfirst();// 1

		while (!LinkListEvent.last()) // n
		{ // events to delete
			LinkListEvent.retreive().getContactsinvolved().findfirst();
			while (!LinkListEvent.retreive().getContactsinvolved().last()) {
				if (LinkListEvent.retreive().getContactsinvolved().retreive().getContactName().equals(contact_to_delete))// n
				{
					LinkListEvent.retreive().getContactsinvolved().remove();
					if (LinkListEvent.retreive().getContactsinvolved().empty()) {
						LinkListEvent.remove();
						removed_event = true;
					}
					deleted = true;
					break;

				}
				LinkListEvent.retreive().getContactsinvolved().findnext();
			}
			if (!removed_event) {
				if (!deleted) {
					if (LinkListEvent.retreive().getContactsinvolved().retreive().getContactName()
							.equals(contact_to_delete))// n
					{
						LinkListEvent.retreive().getContactsinvolved().remove();
						if (LinkListEvent.retreive().getContactsinvolved().empty()) {
							LinkListEvent.remove();
							removed_event = true;
						}
					}
				}
				if (!removed_event)
					LinkListEvent.findnext();// n
			}
			removed_event = false;
			deleted = false;
		}

		LinkListEvent.retreive().getContactsinvolved().findfirst();
		while (!LinkListEvent.retreive().getContactsinvolved().last()) {
			if (LinkListEvent.retreive().getContactsinvolved().retreive().getContactName().equals(contact_to_delete))// n
			{
				LinkListEvent.retreive().getContactsinvolved().remove();
				if (LinkListEvent.retreive().getContactsinvolved().empty()) {
					LinkListEvent.remove();
				}
				deleted = true;
				break;

			}
			LinkListEvent.retreive().getContactsinvolved().findnext();
		}
		if (!deleted) {
			if (LinkListEvent.retreive().getContactsinvolved().retreive().getContactName().equals(contact_to_delete))// n
			{
				LinkListEvent.retreive().getContactsinvolved().remove();
				if (LinkListEvent.retreive().getContactsinvolved().empty()) {
					LinkListEvent.remove();
				}
			}
		}

	}

	public void delete_Appointment(String contact_to_delete) { // bigO(n^2) total=n^2+4n+4

		if (LinkListAppointment.empty())// 1
		{ // no events to delete
			return;// 1
		}

		LinkListAppointment.findfirst();// 1

		while (!LinkListAppointment.last()) // n
		{ // events to delete
			if (LinkListAppointment.retreive().getContactinvolved().getContactName().equals(contact_to_delete))// n
			{
				LinkListAppointment.remove();// n*n
			} else// n
				LinkListAppointment.findnext();// n
		}
		if (LinkListAppointment.retreive().getContactinvolved().getContactName().equals(contact_to_delete))// 1
			LinkListAppointment.remove();// n
	}

	public void addevent() // bigO(n) total=4n+18
	{
		String newname;
		int index = 0;
		linkedlist<Contact> LinkListConatact = new linkedlist<>();

		System.out.print("enter event title: ");// 1
		String title = input.nextLine();// 1

		
		System.out.print("Enter contact's name spreated by comma: ");// 1
		String cname = input.nextLine();// 1

		do {
			newname = extractnames(cname, index);

			Contact cc = ListConatact.search_name(newname);// n
			if (cc == null) // 1
			{
				System.out.println("no contact found with this name");// 1
				return;// 1
			} else {
				LinkListConatact.Insert(cc);
			}

			int windex = 0;
			while (windex < newname.length() + 1)// n+1
			{
				index++;// n
				windex++;// n
			}

		} while (newname != null && index < cname.length());

		System.out.print("Enter event date and time (DD/MM/YYYY HH:MM): ");// 1
		String date_time = input.nextLine();// 1
		try {
			if (!validateDate(date_time)) {
				System.out.println("Date and time are invalid.");
				return;
			}
		} catch (Exception e) {
			System.out.println("The format does not match");
			return;
		}
		if (searchdate_time(date_time)) // n
		{
			System.out.println("date and time title exists");// 1
			return;// 1
		}

		System.out.print("Enter event location: ");// 1
		String location = input.nextLine();// 1
		Event e = new Event(title, date_time, location, LinkListConatact);// 1
		LinkListEvent.Insert(e);// n
		System.out.println("Event scheduled successfully! ");// 1

		// }

	}

	public String extractnames(String namelist, int index) {

		char currentChar = namelist.charAt(index);// 1
		String fullname = "";// 1

		while (currentChar != ',' && index < namelist.length())// n+1
		{
			fullname += currentChar;// n
			index++;// n
			if (index < namelist.length())// n
			{
				currentChar = namelist.charAt(index);// n
			}
		}

		return fullname;// 1

	}

	public void addAppointment() // bigO(n) total=4n+18
	{
		System.out.print("enter Appointment title: ");// 1
		String title = input.nextLine();// 1

		
		System.out.print("Enter contact's name: ");// 1
		String cname = input.nextLine();// 1
		Contact cc = ListConatact.search_name(cname);// logn
		if (cc == null) // 1
		{
			System.out.println("no contact found with this name");// 1
			return;// 1
		} else // 1
		{
			System.out.print("Enter Appointment date and time (DD/MM/YYYY HH:MM): ");// 1
			String date_time = input.nextLine();// 1
			try {
				if (!validateDate(date_time)) {
					System.out.println("Date and time are invalid.");
					return;
				}
			} catch (Exception e) {
				System.out.println("The format does not match");
				return;
			}
			if (searchdate_time_A(date_time)) // n
			{
				System.out.println("date and time title exists");// 1
				return;// 1
			}

			System.out.print("Enter Appointment location: ");// 1
			String location = input.nextLine();// 1
			Appointment a = new Appointment(title, date_time, location, ListConatact.search_name(cname));// 1
			LinkListAppointment.Insert(a);// n
			System.out.println("Appointment scheduled successfully! ");// 1
		}

		// }

	}

	public boolean searchdate_time_A(String Date_Time)// bigO(n) total=3n+8
	{

		if (LinkListAppointment.empty()) // 1
		{
			return false;// 1
		}

		LinkListAppointment.findfirst();// 1

		while (!LinkListAppointment.last())// n+1
		{
			if ((LinkListAppointment.retreive()).getDate_Time().equalsIgnoreCase(Date_Time))// n
				return true;// 1
			LinkListAppointment.findnext();// n
		}

		if (LinkListAppointment.retreive().getDate_Time().equalsIgnoreCase(Date_Time)) // 1 for last case
			return true;// 1

		return false;// 1

	}

	public boolean searchdate_time(String Date_Time)// bigO(n) total=3n+8
	{

		if (LinkListEvent.empty()) // 1
		{
			return false;// 1
		}

		LinkListEvent.findfirst();// 1

		while (!LinkListEvent.last())// n+1
		{
			if ((LinkListEvent.retreive()).getDate_Time().equalsIgnoreCase(Date_Time))// n
				return true;// 1
			LinkListEvent.findnext();// n
		}

		if (LinkListEvent.retreive().getDate_Time().equalsIgnoreCase(Date_Time)) // 1 for last case
			return true;// 1

		return false;// 1

	}

	public void print_events(String t, int x) // bigO(n) total=19+9n
	{
		int found = 0;// 1

		if (LinkListEvent.empty())// 1
		{
			System.out.println("event is empty");// 1
			return;// 1
		}
		if (x == 1) // 1
		{
			LinkListEvent.findfirst();// 1
			while (!LinkListEvent.last()) // n+1
			{
				LinkListEvent.retreive().getContactsinvolved().findfirst();
				while (!LinkListEvent.retreive().getContactsinvolved().last()) {

					if (LinkListEvent.retreive().getContactsinvolved().retreive().getContactName().equalsIgnoreCase(t)) // n
					{
						if (found != 1)
							System.out.println("Events found!");

						System.out.println(LinkListEvent.retreive().toString());// n
						found = 1;// n
						break;
					}
					LinkListEvent.retreive().getContactsinvolved().findnext();
				}
				if (found != 1) {
					if (LinkListEvent.retreive().getContactsinvolved().retreive().getContactName().equalsIgnoreCase(t)) // n
					{

						System.out.println("Events found!");
						System.out.println(LinkListEvent.retreive().toString());// n
						found = 1;
					}
				}
				LinkListEvent.findnext();// n
				found = 2;
			}

			LinkListEvent.retreive().getContactsinvolved().findfirst();
			while (!LinkListEvent.retreive().getContactsinvolved().last()) {

				if (LinkListEvent.retreive().getContactsinvolved().retreive().getContactName().equalsIgnoreCase(t)) // n
				{

					System.out.println("Events found!");

					System.out.println(LinkListEvent.retreive().toString());// n
					found = 1;// n
					break;
				}
				LinkListEvent.retreive().getContactsinvolved().findnext();
			}
			if (found != 1) {
				if (LinkListEvent.retreive().getContactsinvolved().retreive().getContactName().equalsIgnoreCase(t)) // n
				{

					System.out.println("Events found!");

					System.out.println(LinkListEvent.retreive().toString());// n
					found = 1;// n
				}
			}
			if (found == 0)// 1
				System.out.println("no matching events found");// 1
		}

		else // 1
		{
			LinkListEvent.findfirst();// 1
			while (!LinkListEvent.last()) // n+1
			{
				if (LinkListEvent.retreive().getTitle().equalsIgnoreCase(t)) // n
				{
					if (found == 0)
						System.out.println("Event found!");
					System.out.println(LinkListEvent.retreive().toString());// n
					found = 1;// n
				}
				LinkListEvent.findnext();// n
			}

			if (LinkListEvent.retreive().getTitle().equalsIgnoreCase(t)) // 1
			{
				if (found == 0)
					System.out.println("Event found!");
				System.out.println(LinkListEvent.retreive().toString());// n
				found = 1;// n
			}
			if (found == 0)// 1
				System.out.println("no matching events found");// 1
		}

	}

	public void print_appointment(String t, int x) // bigO(n) total=19+9n
	{
		int found = 0;// 1

		if (LinkListAppointment.empty())// 1
		{
			System.out.println("appointment list is empty");// 1
			return;// 1
		}
		if (x == 1) // 1
		{
			LinkListAppointment.findfirst();// 1
			while (!LinkListAppointment.last()) // n+1
			{

				if (LinkListAppointment.retreive().getContactinvolved().getContactName().equalsIgnoreCase(t)) // n
				{
					if (found == 0)
						System.out.println("appointments found!");

					System.out.println(LinkListAppointment.retreive().toString());// n
					found = 1;// n
				}
				LinkListAppointment.findnext();
			}

			if (LinkListAppointment.retreive().getContactinvolved().getContactName().equalsIgnoreCase(t)) // n
			{
				if (found == 0)
					System.out.println("appointments found!");

				System.out.println(LinkListAppointment.retreive().toString());// n
				found = 1;// n
			}

		}

		else // 1
		{
			LinkListAppointment.findfirst();// 1
			while (!LinkListAppointment.last()) // n+1
			{
				if (LinkListAppointment.retreive().getTitle().equalsIgnoreCase(t)) // n
				{
					if (found == 0)
						System.out.println("appointments found!");
					System.out.println(LinkListAppointment.retreive().toString());// n
					found = 1;// n
				}
				LinkListAppointment.findnext();// n
			}

			if (LinkListAppointment.retreive().getTitle().equalsIgnoreCase(t)) // 1
			{
				if (found == 0)
					System.out.println("appointments found!");
				System.out.println(LinkListAppointment.retreive().toString());// n
				found = 1;// n
			}
		}
		if (found == 0)// 1
			System.out.println("no matching events found");// 1

	}

	public String extractfirst(String fullname) // bigO(n) total=5n+5
	{ // this method is to extract each first name form the list of contact

		int index = 0;// 1
		char currentChar = fullname.charAt(index);// 1
		String firstname = "";// 1

		while (currentChar != ' ' && index < fullname.length())// n+1
		{
			firstname += currentChar;// n
			index++;// n
			if (index < fullname.length())// n
			{
				currentChar = fullname.charAt(index);// n
			}
		}

		return firstname;// 1

	}

	public void print_events_alpha() // bigO(n) total=3n+6
	{

		if (LinkListEvent.empty()) // 1
		{
			System.out.println("no events");// 1
			return; // 1
		}
		LinkListEvent.findfirst();// 1

		while (!LinkListEvent.last()) // n+1
		{
			System.out.println(LinkListEvent.retreive().toString());// n
			LinkListEvent.findnext();// n
		}
		System.out.println(LinkListEvent.retreive().toString());// 1

	}

	public void print_apps_alpha() {
		if (LinkListAppointment.empty()) // 1
		{
			System.out.println("no apps");// 1
			return; // 1
		}
		LinkListAppointment.findfirst();// 1

		while (!LinkListAppointment.last()) // n+1
		{
			System.out.println(LinkListAppointment.retreive().toString());// n
			LinkListAppointment.findnext();// n
		}
		System.out.println(LinkListAppointment.retreive().toString());// 1

	}

	public boolean validateDate(String date) {
		int day = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(3, 5));
		int year = Integer.parseInt(date.substring(6, 10));
		int hour = Integer.parseInt(date.substring(11, 13));
		int minute = Integer.parseInt(date.substring(14, 16));

		if (date.length() != 16 || date.charAt(2) != '/' || date.charAt(5) != '/' || date.charAt(10) != ' '
				|| date.charAt(13) != ':') {
			return false;
		}

		if (day < 1 || day > 31) {
			return false;
		}

		if (month < 1 || month > 12) {
			return false;
		}

		if (year < 1900 || year > 2100) {
			return false;
		}
		if (hour < 0 || hour > 23) {
			return false;
		}

		if (minute < 0 || minute > 59) {
			return false;
		}

		if (month == 2 && day == 29 && year % 4 != 0) {
			return false;
		}

		return true;
	}

}