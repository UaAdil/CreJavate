package Modules.module1.Library;

public class Reader {
    private String name;
    private int readerId;

    public Reader(String name, int readerId) {
        this.name = name;
        this.readerId = readerId;
    }

    public String getName() {
        return name;
    }

    public int getReaderId() {
        return readerId;
    }

    @Override
    public String toString() {
        return "Reader [Name=" + name + ", Reader ID=" + readerId + "]";
    }
}
