import java.util.HashMap;
import java.util.Map;
public class ContactManager
{
    private Map<String, Contact> contacts;
    public ContactManager()
    {
        contacts = new HashMap<>();
    }
    public void addContact(String name, String phoneNumber, String email)
    {
        Contact contact = new Contact(name, phoneNumber, email);
        contacts.put(name, contact);
    }
    public void updateContact(String name, String phoneNumber, String email)
    {
        Contact contact = contacts.get(name);
        if (contact != null)
        {
            contact.setPhoneNumber(phoneNumber);
            contact.setEmail(email);
        }
    }
    public void removeContact(String name)
    {
        contacts.remove(name);
    }
    public Map<String, Contact> getAllContacts()
    {
        return contacts;
    }
    public Contact getContact(String name)
    {
        return contacts.get(name);
    }
}
