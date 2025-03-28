import java.io.Serializable;





public class Book implements Serializable{
    private int bookID;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;

    public Book(int bookID, String title, String author, String genre, String availabilityStatus) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        setAvailabilityStatus(availabilityStatus);
    }

    public int getBookID() { return bookID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getAvailabilityStatus() { return availabilityStatus; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }


    public void setAvailabilityStatus(String availabilityStatus) {
        if (availabilityStatus.equalsIgnoreCase("Available") || availabilityStatus.equalsIgnoreCase("Checked Out")) {
            this.availabilityStatus = availabilityStatus;
        } else {
            throw new IllegalArgumentException("Invalid status. Choose 'Available' or 'Checked Out'.");
        }
    }

    @Override
    public String toString() {
        return "Book ID: " + bookID + ", Title: " + title + ", Author: " + author +
                ", Genre: " + genre + ", Status: " + availabilityStatus;
    }
}
