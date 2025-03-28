import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer, Book> books = new HashMap<>();

    public void addBook(Book book) {
        if (!books.containsKey(book.getBookID())) {
            books.put(book.getBookID(), book);
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Book ID already exists!");
        }
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        books.values().forEach(System.out::println);
    }

    public Book searchBookByID(int bookID) {
        return books.get(bookID);
    }

    public Book searchBookByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public void updateBook(int bookID, String title, String author, String genre, String status) {
        Book book = books.get(bookID);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            book.setGenre(genre);
            book.setAvailabilityStatus(status);
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void deleteBook(int bookID) {
        if (books.remove(bookID) != null) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }
}
