package Modules.module6.lab5;

public class PrototypeTest {
    public static void main(String[] args) {
        Document originalDocument = new Document("My Document", "This is the content.");
        originalDocument.addSection(new Section("Introduction", "This is the introduction."));
        originalDocument.addImage(new Image("https://www.mytaskpanel.com/wp-content/uploads/2023/04/consulting-blog-09.webp"));

        System.out.println("Original Document: " + originalDocument);

        DocumentManager manager = new DocumentManager();

        Document clonedDocument = (Document) manager.createDocument(originalDocument);
        clonedDocument.setTitle("Cloned Document");
        clonedDocument.getSections().get(0).setText("Updated introduction text.");
        clonedDocument.addImage(new Image("https://www.mytaskpanel.com/wp-content/uploads/2023/04/consulting-blog-09.webp"));

        System.out.println("Cloned Document: " + clonedDocument);

        System.out.println("Original Document after cloning: " + originalDocument);
    }
}
