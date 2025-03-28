package com.library.services;

import com.library.models.Book;
import java.util.HashMap;
import java.util.Map;

/**
 * Library class manages books in the digital library system.
 */
public class Library {
    private final Map<Integer, Book> books = new HashMap<>();

    /**
     * Adds a new book to the library.
     * Ensures the book ID is unique.
     *
     * @param book The book to be added.
     */
    public void addBook(Book book) {
        if (!books.containsKey(book.getBookId())) {
            books.put(book.getBookId(), book);
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Book ID already exists! Cannot add duplicate books.");
        }
    }

    /**
     * Displays all books in the library.
     * If no books are available, it informs the user.
     */
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        books.values().forEach(System.out::println);
    }

    /**
     * Searches for a book by its unique ID.
     *
     * @param bookId The ID of the book.
     * @return The book if found, otherwise null.
     */
    public Book searchBookById(int bookId) {
        return books.getOrDefault(bookId, null);
    }

    /**
     * Searches for a book by its title (case-insensitive).
     *
     * @param title The title of the book.
     * @return The book if found, otherwise null.
     */
    public Book searchBookByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    /**
     * Updates an existing book's details.
     *
     * @param bookId The ID of the book to update.
     * @param title  The new title.
     * @param author The new author.
     * @param genre  The new genre.
     * @param status The new availability status.
     */
    public void updateBook(int bookId, String title, String author, String genre, String status) {
        Book book = books.get(bookId);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            book.setGenre(genre);
            book.setAvailabilityStatus(status);
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Book not found! Unable to update.");
        }
    }

    /**
     * Deletes a book from the library based on the given book ID.
     *
     * @param bookId The ID of the book to be deleted.
     */
    public void deleteBook(int bookId) {
        if (books.remove(bookId) != null) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found! Cannot delete.");
        }
    }
}
