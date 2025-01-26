import java.util.*;

class Contact {
    int cid;
    String cname;
    String ctype;
    Set<Integer> phoneno;

    public Contact(int cid, String cname, String ctype, Set<Integer> phoneno) {
        this.cid = cid;
        this.cname = cname;
        this.ctype = ctype;
        this.phoneno = phoneno;
    }
}

class PhoneBook {
    String cat;
    int count; // Represents the number of contacts
    List<Contact> contacts;

    public PhoneBook(String cat, List<Contact> contacts) {
        this.cat = cat;
        this.contacts = contacts;
        this.count = contacts.size(); // Automatically calculate the count
    }

    // Method to display all contacts with a specific name
    public void displayContactsByName(String name) {
        for (Contact contact : contacts) {
            if (contact.cname.equalsIgnoreCase(name)) {
                System.out.println(contact.cid + " " + contact.ctype + " " + contact.phoneno);
            }
        }
    }

    // Method to find a contact name by ID
    public String findContactNameById(int contactId) {
        for (Contact contact : contacts) {
            if (contact.cid == contactId) {
                return contact.cname;
            }
        }
        return "Contact not found";
    }

    // Method to display all contacts
    public void displayAllContacts() {
        System.out.println(cat + " " + count);
        for (Contact contact : contacts) {
            System.out.println(contact.cid + " " + contact.cname + " " + contact.ctype + " " + contact.phoneno);
        }
    }
}

public class Practoce_2ai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input the phonebook category
        String category = in.nextLine();

        // Input the number of contacts
        int noc = Integer.parseInt(in.nextLine());

        List<Contact> contactList = new ArrayList<>();

        for (int i = 0; i < noc; i++) {
            int cid = Integer.parseInt(in.nextLine());
            String cname = in.nextLine();
            String ctype = in.nextLine();
            int noOfPhoneNumbers = Integer.parseInt(in.nextLine());
            Set<Integer> phoneNumbers = new HashSet<>();

            for (int j = 0; j < noOfPhoneNumbers; j++) {
                int phone = Integer.parseInt(in.nextLine());
                phoneNumbers.add(phone);
            }

            Contact contact = new Contact(cid, cname, ctype, phoneNumbers);
            contactList.add(contact);
        }

        // Create the phonebook
        PhoneBook phoneBook = new PhoneBook(category, contactList);

        // Display all contacts
        phoneBook.displayAllContacts();

        // Search contacts by name
        String searchName = in.nextLine();
        phoneBook.displayContactsByName(searchName);

        // Search for a contact by ID
        int searchId = Integer.parseInt(in.nextLine());
        System.out.println(phoneBook.findContactNameById(searchId));
    }
}
