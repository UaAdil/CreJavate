package Modules.module1.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        // Create book
        Book book1 = new Book("Atomic habits", "James Clear", "1234567890", 5);
        Book book2 = new Book("A song of Ice and Fire", "George Martin", "0987654321", 3);
        Book book3 = new Book("Think and grow rich", "Napoleon Hill", "1234554321", 4);
        // add book
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        // create reader
        Reader reader1 = new Reader("Adil", 1);
        Reader reader2 = new Reader("Dias", 2);
        Reader reader3 = new Reader("Jon Snow", 3);
        // register reader
        library.registerReader(reader1);
        library.registerReader(reader2);
        library.registerReader(reader3);
        // lend book
        library.lendBook("1234567890", 1);
        library.lendBook("3253355323", 3);
        // return book
        library.returnBook("1234567890");
        // remove book
        library.removeBook("0987654321");
        library.removeBook("1234554321");
        // remove reader
        library.removeReader(2);
    }
}
