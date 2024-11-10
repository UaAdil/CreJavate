package Modules.module10.hometask9;

import java.util.ArrayList;
import java.util.List;

abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract void display(int depth);

    public abstract int getSize();

    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot add.");
    }

    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot remove.");
    }
}

class File extends FileSystemComponent {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public void display(int depth) {
        System.out.println(" ".repeat(depth) + "- File: " + name + " (Size: " + size + ")");
    }

    @Override
    public int getSize() {
        return size;
    }
}

class Directory extends FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    public void display(int depth) {
        System.out.println(" ".repeat(depth) + "+ Directory: " + name);
        for (FileSystemComponent component : children) {
            component.display(depth + 2);
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }
}


public class FileSystem {
    public static void main(String[] args) {
        Directory dir = new Directory("Defaults");
        File file1 = new File("default1.txt", 400);
        File file2 = new File("default2.txt", 600);

        Directory subDef = new Directory("subDefault");
        File subFile1 = new File("subFile.txt", 300);
        subDef.add(subFile1);

        dir.add(file1);
        dir.add(file2);
        dir.add(subDef);

        dir.display(1);
        System.out.println("size: " + dir.getSize() + "KB");
    }
}

