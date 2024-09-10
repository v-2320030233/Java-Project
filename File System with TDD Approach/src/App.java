import java.util.Scanner;
public class App
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the root directory:");
        String rootDirName = scanner.nextLine();
        Directory root = new Directory(rootDirName);
        boolean continueAdding = true;
        while (continueAdding)
        {
            System.out.println("Do you want to add a file or a directory? (f/d):");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("f"))
            {
                System.out.println("Enter the name of the file:");
                String fileName = scanner.nextLine();
                File file = new File(fileName);
                addEntityToDirectory(scanner, root, file);
            }
            else if (choice.equalsIgnoreCase("d"))
            {
                System.out.println("Enter the name of the directory:");
                String dirName = scanner.nextLine();
                Directory dir = new Directory(dirName);
                addEntityToDirectory(scanner, root, dir);
            } else
            {
                System.out.println("Invalid input, please enter 'f' for file or 'd' for directory.");
            }
            System.out.println("Do you want to add another entity? (y/n):");
            continueAdding = scanner.nextLine().equalsIgnoreCase("y");
        }
        System.out.println("\nFile system structure:");
        root.print("");
    }
    private static void addEntityToDirectory(Scanner scanner, Directory root, FileSystemEntity entity) {
        System.out.println("Where would you like to add this entity? Enter the full path, or just press enter to add to root:");
        String path = scanner.nextLine();
        if (path.isEmpty())
        {
            root.add(entity);
        }
        else
        {
            Directory targetDir = findDirectoryByPath(root, path);
            if (targetDir != null)
            {
                targetDir.add(entity);
            }
            else
            {
                System.out.println("Invalid path. Entity will be added to the root directory.");
                root.add(entity);
            }
        }
    }

    // Helper method to find a directory by its path (relative to the root)
    private static Directory findDirectoryByPath(Directory root, String path) {
        String[] directories = path.split("/");
        Directory current = root;

        for (String dirName : directories) {
            boolean found = false;
            for (FileSystemEntity entity : current.getContents()) {
                if (entity instanceof Directory && entity.getName().equals(dirName)) {
                    current = (Directory) entity;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return null;
            }
        }
        return current;
    }
}
