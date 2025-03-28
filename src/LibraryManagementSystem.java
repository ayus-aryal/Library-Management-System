import java.util.Scanner;

public class LibraryManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n Digital Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Update Book Details");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> library.viewAllBooks();
                case 3 -> searchByID();
                case 4 -> searchByTitle();
                case 5 -> updateBook();
                case 6 -> deleteBook();
                case 7 -> {
                    System.out.println("Exiting system...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability (Available/Checked Out): ");
        String status = scanner.nextLine();

        Book book = new Book(id, title, author, genre, status);
        library.addBook(book);
    }

    private static void searchByID() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        Book book = library.searchBookByID(id);
        System.out.println(book != null ? book : "Book not found.");
    }

    private static void searchByTitle() {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        Book book = library.searchBookByTitle(title);
        System.out.println(book != null ? book : "Book not found.");
    }

    private static void updateBook() {
        System.out.print("Enter Book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter New Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter New Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter New Availability (Available/Checked Out): ");
        String status = scanner.nextLine();

        library.updateBook(id, title, author, genre, status);
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = scanner.nextInt();
        library.deleteBook(id);
    }
}
