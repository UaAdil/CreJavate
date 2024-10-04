package Modules.module1.Library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        books = new ArrayList<>();
        readers = new ArrayList<>();
    }

    // adding books
    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " added into library.");
    }

    // removing books
    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        System.out.println("A book with ISBN " + isbn + "was removed.");
    }

    // Registration reader
    public void registerReader(Reader reader) {
        readers.add(reader);
        System.out.println(reader.getName() + " registered in the library.");
    }

    // removing reader
    public void removeReader(int readerId) {
        readers.removeIf(reader -> reader.getReaderId() == readerId);
        System.out.println("A reader with ID " + readerId + "was removed.");
    }

    // Giving a book to a reader
    public void lendBook(String isbn, int readerId) {
        Book book = findBookByIsbn(isbn);
        if (book != null && book.getCopies() > 0) {
            book.setCopies(book.getCopies() - 1);
            System.out.println("The Book " + book.getTitle() + " issued to the reader with an ID " + readerId);
        } else {
            System.out.println("The Book is not available.");
        }
    }

    // Return of the book
    public void returnBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null) {
            book.setCopies(book.getCopies() + 1);
            System.out.println("The book " + book.getTitle() + " was returned.");
        } else {
            System.out.println("The book is not found.");
        }
    }

    // Book search by ISBN
    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Modules.module1.Library [Books=" + books + ", Readers=" + readers + "]";
    }
}
