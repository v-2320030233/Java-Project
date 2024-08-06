import java.util.ArrayList;
import java.util.List;
public class Directory extends FileSystemEntity 
{
    private List<FileSystemEntity> contents;
    public Directory(String name)
     {
        super(name);
        this.contents = new ArrayList<>();
    }
    public void add(FileSystemEntity entity) 
    {
        contents.add(entity);
    }
    @Override
    public void print(String indent) 
    {
        System.out.println(indent + "Directory: " + name);
        for (FileSystemEntity entity : contents) 
        {
            entity.print(indent + "  ");
        }
    }
    public List<FileSystemEntity> getContents()
     {
        return contents;
    }
}
