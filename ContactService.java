package contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        for (Contact existingContact : contacts) {
            if (existingContact.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID already exists");
            }
        }

        contacts.add(contact);
    }

    public void deleteContact(String contactId) {
        Contact contact = findContact(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contacts.remove(contact);
    }

    public void updateContact(String contactId, String firstName,
                              String lastName, String phone, String address) {

        Contact contact = findContact(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }

    public Contact findContact(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }

        return null;
    }
}
