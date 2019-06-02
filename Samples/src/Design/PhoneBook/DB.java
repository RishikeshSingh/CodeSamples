package Design.PhoneBook;

import java.util.ArrayList;

public class DB {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String number){
        Contact contact = new Contact(name, number);
        contacts.add(contact);
        System.out.println("Contact added : "+contact.getName()+ contact.getNumber());
    }

    boolean isNumber(String str){
        if(str.matches("\\d+"))
            return true;
        else
            return false;
    }

    public Contact find(String identifier){
        if(isNumber(identifier)){
            for(Contact contact: contacts){
                if(contact.getNumber().equals(identifier)){
                    return contact;
                }

            }
        }else{
            for(Contact contact: contacts){
                if(contact.getName().equals(identifier)){
                    return contact;
                }

            }
        }

        return null;
    }

    void displayAllContacts(){
        System.out.println("list of all contacts");
        for(Contact contact: contacts){
            System.out.println(contact.getName()+" "+contact.getNumber());
        }
    }
}
