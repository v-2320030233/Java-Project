import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ContactManagerTest
{
    private ContactManager contactManager;
    @BeforeEach
    void setUp()
    {
        contactManager = new ContactManager();
    }
    @Test
    void testAddContact()
    {
        contactManager.addContact("John Doe", "1234567890", "john@example.com");
        Contact contact = contactManager.getContact("John Doe");
        assertNotNull(contact);
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("john@example.com", contact.getEmail());
    }
    @Test
    void testUpdateContact()
    {
        contactManager.addContact("John Doe", "1234567890", "john@example.com");
        contactManager.updateContact("John Doe", "0987654321", "john.doe@example.com");
        Contact updatedContact = contactManager.getContact("John Doe");
        assertEquals("0987654321", updatedContact.getPhoneNumber());
        assertEquals("john.doe@example.com", updatedContact.getEmail());
    }
    @Test
    void testRemoveContact()
    {
        contactManager.addContact("John Doe", "1234567890", "john@example.com");
        contactManager.removeContact("John Doe");
        Contact contact = contactManager.getContact("John Doe");
        assertNull(contact);
    }
    @Test
    void testListAllContacts()
    {
        contactManager.addContact("John Doe", "1234567890", "john@example.com");
        contactManager.addContact("Jane Doe", "0987654321", "jane@example.com");
        Map<String, Contact> contacts = contactManager.getAllContacts();
        assertEquals(2, contacts.size());
    }
}
