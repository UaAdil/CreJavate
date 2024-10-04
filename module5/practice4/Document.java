package Modules.module5.practice4;

public interface Document {
    void Open();
}

class Report implements Document {
    @Override
    public void Open() {
        System.out.println("Opening the report document.");
    }
}

class Resume implements Document {
    @Override
    public void Open() {
        System.out.println("Opening the resume document.");
    }
}

class Letter implements Document {
    @Override
    public void Open() {
        System.out.println("Opening the letter document");
    }
}

class Invoice implements Document {
    @Override
    public void Open() {
        System.out.println("Opening the invoice document.");
    }
}