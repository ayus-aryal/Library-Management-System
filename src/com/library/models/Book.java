package com.library.models;

import java.io.Serializable;

/**
 * Represents a book in the library system.
 */
public class Book implements Serializable {
    private int bookId;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;

    /**
     * Creates a new book object.
     *
     * @param bookId            The unique ID of the book (must be positive).
     * @param title             The title of the book (cannot be empty).
     * @param author            The author's name (cannot be empty).
     * @param genre             The genre of the book (cannot be empty).
     * @param availabilityStatus The availability status ("Available" or "Checked Out").
     * @throws IllegalArgumentException if invalid values are provided.
     */
    public Book(int bookId, String title, String author, String genre, String availabilityStatus) {
        setBookId(bookId);
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
        setAvailabilityStatus(availabilityStatus);
    }

    // Getters
    public int getBookId() { return bookId; }
    public String getTitle() { return title; }

    // Setters with validation
    public void setBookId(int bookId) {
        if (bookId <= 0) {
            throw new IllegalArgumentException("Book ID must be positive.");
        }
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }
        this.author = author;
    }

    public void setGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be empty.");
        }
        this.genre = genre;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        if (!availabilityStatus.equalsIgnoreCase("Available") && !availabilityStatus.equalsIgnoreCase("Checked Out")) {
            throw new IllegalArgumentException("Invalid status. Choose 'Available' or 'Checked Out'.");
        }
        this.availabilityStatus = availabilityStatus;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author +
                ", Genre: " + genre + ", Status: " + availabilityStatus;
    }
}
