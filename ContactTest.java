package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact(
                "12345",
                "Tyler",
                "Smith",
                "7345551234",
                "123 Main St");

        assertEquals("12345", contact.getContactId());
        assertEquals("Tyler", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("7345551234", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Tyler", "Smith",
                    "7345551234", "123 Main St");
        });
    }

    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Tyler", "Smith",
                    "7345551234", "123 Main St");
        });
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Christopher", "Smith",
                    "7345551234", "123 Main St");
        });
    }
    
    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Smith",
                    "7345551234", "123 Main St");
        });
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tyler", "Longlastname",
                    "7345551234", "123 Main St");
        });
    }


    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tyler", null,
                    "7345551234", "123 Main St");
        });
    }

    @Test
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tyler", "Smith",
                    "734555123", "123 Main St");
        });
    }

    @Test
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tyler", "Smith",
                    "73455512345", "123 Main St");
        });
    }

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tyler", "Smith",
                    null, "123 Main St");
        });
    }

    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tyler", "Smith",
                    "7345551234",
                    "This address is definitely longer than thirty characters");
        });
    }

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tyler", "Smith",
                    "7345551234", null);
        });
    }
}