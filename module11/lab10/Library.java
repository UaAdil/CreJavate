package Modules.module11.lab10;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markAsLoaned() {
        this.isAvailable = false;
    }

    public void markAsAvailable() {
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Book [Title=" + title + ", Author=" + author + ", ISBN=" + isbn + ", IsAvailable=" + isAvailable + "]";
    }
}

class Reader {
    private int id;
    private String name;
    private String email;
    private List<Book> borrowedBooks;

    public Reader(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.markAsLoaned();
            System.out.println(name + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Book " + book.getTitle() + " is not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.markAsAvailable();
            System.out.println(name + " returned: " + book.getTitle());
        } else {
            System.out.println("This book was not borrowed by " + name);
        }
    }

    @Override
    public String toString() {
        return "Reader [Id=" + id + ", Name=" + name + ", Email=" + email + ", BorrowedBooks=" + borrowedBooks + "]";
    }
}


class Librarian {
    private int id;
    private String name;
    private String position;
    private List<Book> libraryBooks;

    public Librarian(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.libraryBooks = new ArrayList<>();
    }

    public void addBook(Book book) {
        libraryBooks.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(Book book) {
        if (libraryBooks.remove(book)) {
            System.out.println("Book removed: " + book.getTitle());
        } else {
            System.out.println("Book not found in library: " + book.getTitle());
        }
    }

    public void listAvailableBooks() {
        System.out.println("Available books:");
        for (Book book : libraryBooks) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }
}


class Loan {
    private Book book;
    private Reader reader;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(Book book, Reader reader) {
        this.book = book;
        this.reader = reader;
        this.loanDate = LocalDate.now();
    }

    public void completeLoan() {
        this.returnDate = LocalDate.now();
        book.markAsAvailable();
        System.out.println("Loan completed for book: " + book.getTitle() + " by " + reader.getName());
    }

    @Override
    public String toString() {
        return "Loan [Book=" + book.getTitle() + ", Reader=" + reader.getName() + ", LoanDate=" + loanDate
                + ", ReturnDate=" + (returnDate != null ? returnDate : "Not returned yet") + "]";
    }
}



public class Library{
    public static void main(String[] args) {
        Librarian librarian = new Librarian(1, "Daulet Kerimov", "Chief Librarian");

        Book book1 = new Book("Think and grow rich", "Napoleon Hill", "67810");
        Book book2 = new Book("Atomic habits", "James Clear", "67890");
        librarian.addBook(book1);
        librarian.addBook(book2);

        Reader reader = new Reader(1, "Adil khan", "adil@example.com");
        reader.borrowBook(book1);
        reader.borrowBook(book2);

        librarian.listAvailableBooks();

        reader.returnBook(book1);
        librarian.listAvailableBooks();

        Loan loan = new Loan(book1, reader);
        loan.completeLoan();
    }
}
