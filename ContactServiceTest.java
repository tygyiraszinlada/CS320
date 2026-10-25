package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345", "Tyler", "Smith",
                "7345551234", "123 Main St");

        service.addContact(contact);

        assertEquals(contact, service.findContact("12345"));
    }

    @Test
    void testAddDuplicateContactId() {
        ContactService service = new ContactService();

        Contact contact1 = new Contact(
                "12345", "Tyler", "Smith",
                "7345551234", "123 Main St");

        Contact contact2 = new Contact(
                "12345", "John", "Jones",
                "3135551234", "456 Main St");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345", "Tyler", "Smith",
                "7345551234", "123 Main St");

        service.addContact(contact);
        service.deleteContact("12345");

        assertNull(service.findContact("12345"));
    }

    @Test
    void testDeleteContactNotFound() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("12345");
        });
    }

    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345", "Tyler", "Smith",
                "7345551234", "123 Main St");

        service.addContact(contact);

        service.updateContact(
                "12345",
                "John",
                "Jones",
                "3135551234",
                "456 Oak St");

        Contact updatedContact = service.findContact("12345");

        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Jones", updatedContact.getLastName());
        assertEquals("3135551234", updatedContact.getPhone());
        assertEquals("456 Oak St", updatedContact.getAddress());

        // The contact ID should remain unchanged.
        assertEquals("12345", updatedContact.getContactId());
    }

    @Test
    void testUpdateContactNotFound() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact(
                    "99999",
                    "John",
                    "Jones",
                    "3135551234",
                    "456 Oak St");
        });
    }
}