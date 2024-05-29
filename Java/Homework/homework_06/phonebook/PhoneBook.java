package phonebook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import contacts.Contact;

public class PhoneBook {

    private Map<Contact, List<Long>> phoneBook = new HashMap<>();

    public void addPhonenumber(String firstname, String lastname, long phonenumber) {
        if (!validContactData(firstname, lastname))
            return;

        Contact newContact = new Contact(firstname, lastname);

        if (phoneBook.containsKey(newContact)) {
            phoneBook.get(newContact).add(phonenumber);
        } else {
            List<Long> phonenumbers = new ArrayList<>();
            phonenumbers.add(phonenumber);
            phoneBook.put(newContact, phonenumbers);
        }
    }

    public boolean validContactData(String firstname, String lastname) {
        if (firstname == null || firstname.isEmpty()) {
            System.out.println("Некорректное имя");
            return false;
        } else if (lastname == null || lastname.isEmpty()) {
            System.out.println("Некорректная фамилия");
            return false;
        }
        return true;
    }

    public boolean isContactExist(String firstname, String lastname) {
        if (phoneBook.containsKey(new Contact(firstname, lastname))) {
            return true;
        } else {
            System.out.println("Такого контакта не существует!");
            return false;
        }
    }

    public void deletePhonenumber(String firstname, String lastname, long phonenumber) {
        if (!validContactData(firstname, lastname) || (!isContactExist(firstname, lastname)))
            return;

        Contact contact = new Contact(firstname, lastname);
        phoneBook.get(contact).remove(phonenumber);
    }

    public void deleteContact(String firstname, String lastname) {
        if (!validContactData(firstname, lastname) || (!isContactExist(firstname, lastname)))
            return;

        Contact contact = new Contact(firstname, lastname);
        phoneBook.remove(contact);
    }

    public void printSortedContacts() {
        Comparator<Entry<Contact, List<Long>>> comparator = Comparator
                .comparing(entry -> Integer.valueOf(entry.getValue().size()));
        List<Entry<Contact, List<Long>>> sortedList = new LinkedList<>(phoneBook.entrySet());

        sortedList.sort(comparator.reversed());

        for (Entry<Contact, List<Long>> entry : sortedList) {
            System.out.println(entry);
        }
    }
}