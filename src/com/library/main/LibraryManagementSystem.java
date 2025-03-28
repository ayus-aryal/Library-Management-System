package com.library.main;

import com.library.services.Library;
import com.library.models.Book;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Digital Library Management System - Console-based Application
 */
public class LibraryManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\nDigital Library Management System");
                System.out.println("1️. Add Book");
                System.out.println("2️. View All Books");
                System.out.println("3️. Search Book by ID");
                System.out.println("4️. Search Book by Title");
                System.out.println("5️. Update Book Details");
                System.out.println("6️. Delete Book");
                System.out.println("7️. Exit");
                System.out.print("--> Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> library.viewAllBooks();
                    case 3 -> searchById();
                    case 4 -> searchByTitle();
                    case 5 -> updateBook();
                    case 6 -> deleteBook();
                    case 7 -> {
                        System.out.println("Exiting the system... Goodbye!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    /**
     * Handles adding a new book to the library.
     */
    private static void addBook() {
        try {
            System.out.print("--> Enter Book ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("--> Enter Title: ");
            String title = scanner.nextLine();
            System.out.print("--> Enter Author: ");
            String author = scanner.nextLine();
            System.out.print("--> Enter Genre: ");
            String genre = scanner.nextLine();
            System.out.print("--> Enter Availability (Available/Checked Out): ");
            String status = scanner.nextLine();

            Book book = new Book(id, title, author, genre, status);
            library.addBook(book);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Book ID must be a number.");
            scanner.nextLine(); // Clear buffer
        }
    }

    /**
     * Searches for a book by ID.
     */
    private static void searchById() {
        try {
            System.out.print("--> Enter Book ID: ");
            int id = scanner.nextInt();
            Book book = library.searchBookById(id);
            System.out.println(book != null ? book : " Book not found.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Book ID must be a number.");
            scanner.nextLine(); // Clear buffer
        }
    }

    /**
     * Searches for a book by title.
     */
    private static void searchByTitle() {
        System.out.print("--> Enter Book Title: ");
        String title = scanner.nextLine();
        Book book = library.searchBookByTitle(title);
        System.out.println(book != null ? book : "Book not found.");
    }

    /**
     * Updates an existing book's details.
     */
    private static void updateBook() {
        try {
            System.out.print("--> Enter Book ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("--> Enter New Title: ");
            String title = scanner.nextLine();
            System.out.print("--> Enter New Author: ");
            String author = scanner.nextLine();
            System.out.print("--> Enter New Genre: ");
            String genre = scanner.nextLine();
            System.out.print("--> Enter New Availability (Available/Checked Out): ");
            String status = scanner.nextLine();

            library.updateBook(id, title, author, genre, status);
        } catch (InputMismatchException e) {
            System.out.println(" Invalid input! Book ID must be a number.");
            scanner.nextLine(); // Clear buffer
        }
    }

    /**
     * Deletes a book by ID.
     */
    private static void deleteBook() {
        try {
            System.out.print("--> Enter Book ID to delete: ");
            int id = scanner.nextInt();
            library.deleteBook(id);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Book ID must be a number.");
            scanner.nextLine(); // Clear buffer
        }
    }
}
