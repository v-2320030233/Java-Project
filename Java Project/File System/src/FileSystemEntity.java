public abstract class FileSystemEntity {
    protected String name;

    public FileSystemEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void print(String indent);
}
