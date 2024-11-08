package Modules.module10.lab9;

import java.util.ArrayList;
import java.util.List;

abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract void display(int depth);

    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException();
    }

    public FileSystemComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }
}

class File extends FileSystemComponent {
    public File(String name) {
        super(name);
    }

    @Override
    public void display(int depth) {
        System.out.println(" ".repeat(depth) + "File: " + name);
    }
}

class Directory extends FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public FileSystemComponent getChild(int index) {
        return children.get(index);
    }

    @Override
    public void display(int depth) {
        System.out.println(" ".repeat(depth) + "Directory: " + name);
        for (FileSystemComponent component : children) {
            component.display(depth + 2);
        }
    }
}


public class FileSystem {
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        File file1 = new File("default1.txt");
        File file2 = new File("default2.txt");

        Directory subDir = new Directory("SubDirectory");
        File subFile1 = new File("subFile1.txt");

        root.add(file1);
        root.add(file2);
        subDir.add(subFile1);
        root.add(subDir);

        root.display(1);
    }
}
