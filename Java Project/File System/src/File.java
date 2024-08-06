public class File extends FileSystemEntity {

    public File(String name) {
        super(name);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "File: " + name);
    }
}
