package Modules.module11.practice10;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
class Book {
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String genre, String isbn) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markAsLoaned() {
        isAvailable = false;
    }

    public void markAsReturned() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Book [Title=" + title + ", Author=" + author + ", Genre=" + genre + ", ISBN=" + isbn +
                ", Available=" + isAvailable + "]";
    }
}

abstract class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Reader extends User {
    public Reader(String name) {
        super(name);
    }
}

class Librarian extends User {
    public Librarian(String name) {
        super(name);
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println("Librarian " + getName() + " added a new book: " + book.getTitle());
    }

    public void removeBook(Library library, Book book) {
        library.removeBook(book);
        System.out.println("Librarian " + getName() + " removed the book: " + book.getTitle());
    }
}

class Loan {
    private Book book;
    private Reader reader;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(Book book, Reader reader, LocalDate loanDate) {
        this.book = book;
        this.reader = reader;
        this.loanDate = loanDate;
    }

    public void completeLoan(LocalDate returnDate) {
        this.returnDate = returnDate;
        book.markAsReturned();
    }

    @Override
    public String toString() {
        return "Loan [Book=" + book.getTitle() + ", Reader=" + reader.getName() +
                ", LoanDate=" + loanDate + ", ReturnDate=" + returnDate + "]";
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void displayBooks() {
        books.forEach(System.out::println);
    }
}

class Catalog {
    private Library library;

    public Catalog(Library library) {
        this.library = library;
    }

    public List<Book> searchByTitle(String title) {
        return library.getBooks().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author) {
        return library.getBooks().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> searchByGenre(String genre) {
        return library.getBooks().stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }
}

class AccountingSystem {
    private List<Loan> loans = new ArrayList<>();

    public void registerLoan(Loan loan) {
        loans.add(loan);
    }

    public void displayLoans() {
        loans.forEach(System.out::println);
    }
}


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Catalog catalog = new Catalog(library);
        AccountingSystem accountingSystem = new AccountingSystem();
        Librarian librarian = new Librarian("John");
        Reader reader = new Reader("Alice");

        librarian.addBook(library, new Book("Magic Morning", "Hal Elrod", "self-development", "123456"));
        librarian.addBook(library, new Book("The dance of dragon", "George Martin", "fantasy", "234567"));
        librarian.addBook(library, new Book("Blood and Fire", "George Martin", "fantasy", "345678"));
        librarian.addBook(library, new Book("Poor dad, rich dad", "Robert Kiosaki", "business", "1231456"));
        librarian.addBook(library, new Book("Steve Jobs", "Wolter Aizekson", "biography", "7898466"));

        System.out.println("All books in the library:");
        library.displayBooks();

        Book bookToLoan = catalog.searchByTitle("1984").get(0);
        Loan loan = new Loan(bookToLoan, reader, LocalDate.now());
        accountingSystem.registerLoan(loan);
        bookToLoan.markAsLoaned();

        System.out.println("\nCurrent loans:");
        accountingSystem.displayLoans();


        loan.completeLoan(LocalDate.now().plusDays(7));
        System.out.println("\nLoans after return:");
        accountingSystem.displayLoans();

        System.out.println("\nBooks in the library after return:");
        library.displayBooks();
    }
}

