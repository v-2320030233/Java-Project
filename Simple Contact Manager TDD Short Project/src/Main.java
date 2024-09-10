import java.util.Map;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running)
        {
            System.out.println("\nContact Manager");
            System.out.println("1. Add Contact");
            System.out.println("2. Update Contact");
            System.out.println("3. Remove Contact");
            System.out.println("4. List All Contacts");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option)
            {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    contactManager.addContact(name, phoneNumber, email);
                    System.out.println("Contact added successfully.");
                    break;
                case 2:
                    System.out.print("Enter name of contact to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    contactManager.updateContact(updateName, newPhoneNumber, newEmail);
                    System.out.println("Contact updated successfully.");
                    break;
                case 3:
                    System.out.print("Enter name of contact to remove: ");
                    String removeName = scanner.nextLine();
                    contactManager.removeContact(removeName);
                    System.out.println("Contact removed successfully.");
                    break;
                case 4:
                    Map<String, Contact> contacts = contactManager.getAllContacts();
                    if (contacts.isEmpty())
                    {
                        System.out.println("No contacts found.");
                    }
                    else
                    {
                        for (Map.Entry<String, Contact> entry : contacts.entrySet())
                        {
                            System.out.println(entry.getValue());
                        }
                    }
                    break;
                case 5:  // Exit
                    running = false;
                    System.out.println("Exiting Contact Manager.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }
}
