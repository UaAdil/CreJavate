package Modules.module5.practice4;

public abstract class DocumentCreator {
    public abstract Document CreateDocument();
}

class ReportCreator extends DocumentCreator {
    @Override
    public Document CreateDocument() {
        return new Report();
    }
}

class ResumeCreator extends DocumentCreator {
    @Override
    public Document CreateDocument(){
        return new Resume();
    }
}

class LetterCreator extends DocumentCreator {
    @Override
    public Document CreateDocument(){
        return new Letter();
    }
}

class InvoiceCreator extends DocumentCreator {
    @Override
    public Document CreateDocument(){
        return new Invoice();
    }
}