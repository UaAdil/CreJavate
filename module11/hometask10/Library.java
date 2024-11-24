package Modules.module11.hometask10;
import java.util.ArrayList;
import java.util.List;

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

    public void rent() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            System.out.println("The book \"" + title + "\" is already rented.");
        }
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Book [Title=" + title + ", Author=" + author + ", ISBN=" + isbn + ", Available=" + isAvailable + "]";
    }
}


class Reader {
    private String name;
    private List<Book> rentedBooks;
    private static final int MAX_BOOKS = 3;

    public Reader(String name) {
        this.name = name;
        this.rentedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }

    public void rentBook(Book book) {
        if (rentedBooks.size() >= MAX_BOOKS) {
            System.out.println(name + " cannot rent more than " + MAX_BOOKS + " books.");
            return;
        }

        if (book.isAvailable()) {
            rentedBooks.add(book);
            book.rent();
            System.out.println(name + " rented \"" + book.getTitle() + "\".");
        } else {
            System.out.println("The book \"" + book.getTitle() + "\" is not available.");
        }
    }

    public void returnBook(Book book) {
        if (rentedBooks.remove(book)) {
            book.returnBook();
            System.out.println(name + " returned \"" + book.getTitle() + "\".");
        } else {
            System.out.println(name + " did not rent the book \"" + book.getTitle() + "\".");
        }
    }
}

class Librarian {
    private String name;

    public Librarian(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBookToLibrary(Library library, Book book) {
        library.addBook(book);
        System.out.println("Librarian " + name + " added \"" + book.getTitle() + "\" to the library.");
    }

    public void removeBookFromLibrary(Library library, Book book) {
        library.removeBook(book);
        System.out.println("Librarian " + name + " removed \"" + book.getTitle() + "\" from the library.");
    }
}



public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void displayAvailableBooks() {
        System.out.println("Available books in the library:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void displayAllBooks() {
        System.out.println("All books in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> searchBooksByAuthor(String author) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }
}

class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian("Gertsen");

        Book book1 = new Book("Atomic Habits", "James Clear", "234987");
        Book book2 = new Book("Think and grow rich", "Napoleon Hill", "234567");
        Book book3 = new Book("Song of Ice and Fire", "George Martin", "345678");

        librarian.addBookToLibrary(library, book1);
        librarian.addBookToLibrary(library, book2);
        librarian.addBookToLibrary(library, book3);

        Reader reader = new Reader("Adil");

        library.displayAvailableBooks();

        reader.rentBook(book1);
        reader.rentBook(book2);
        reader.rentBook(book3);
        reader.rentBook(book3);

        library.displayAvailableBooks();

        reader.returnBook(book1);
        library.displayAvailableBooks();

        System.out.println("Search by title 'Atomic Habits': " + library.searchBookByTitle("Atomic Habits"));
        System.out.println("Search by author 'George Martin': " + library.searchBooksByAuthor("George Martin"));
    }
}

