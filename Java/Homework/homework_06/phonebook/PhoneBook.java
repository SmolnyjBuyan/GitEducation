package phonebook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import contacts.Contact;

public class PhoneBook {

    private Map<Contact, List<Long>> phoneBook = new HashMap<>();

    public void addPhonenumber(String name, long phonenumber) {
        Contact newContact = new Contact(name);
        
        if (phoneBook.containsKey(newContact)) {
            phoneBook.get(newContact).add(phonenumber);
        } else {
            newContact.getPhonenumbers().add(phonenumber);
            phoneBook.put(newContact, newContact.getPhonenumbers());
        }
    }

    public void deletePhonenumber(String name, long phonenumber) {
        Contact contact = new Contact(name);

        if (phoneBook.containsKey(contact)) {
            phoneBook.get(contact).remove(phonenumber);
        } else {
            System.out.println("Такого контакта не существует!");
        }
    }

    public void deleteContact(String name) {
        Contact contact = new Contact(name);

        if (phoneBook.containsKey(contact)) {
            phoneBook.remove(contact);
        } else {
            System.out.println("Такого контакта не существует!");
        }
    }

    public void printAll() {
        System.out.println(phoneBook);
    }


    public Map<Contact, List<Long>> getPhoneBook() {
        return phoneBook;
    }

    public void isKey(String name) {
        Contact contact = new Contact(name);
        if (phoneBook.containsKey(contact))
            System.out.println("Yes");
        else
        System.out.println("No");
    }
}