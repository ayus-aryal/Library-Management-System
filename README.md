###  **Digital Library Management System**  

A simple **console-based Library Management System** built with **Java**. It allows users to manage books, including adding, viewing, searching, updating, and deleting them.

##  **Features**  
✔️ Add new books to the library  
✔️ View all available books  
✔️ Search books by **ID** or **Title**  
✔️ Update book details (Title, Author, Genre, Availability)  
✔️ Delete books from the system  
✔️ User-friendly **console interface**  


## 🔧 **Technologies Used**  
- **Java** (Core Java, Object-Oriented Programming)  
- **IntelliJ IDEA** (Recommended IDE)  


## 📁 **Project Structure**  
```plaintext
Library-Management-System/
│── src/
│   ├── com/
│   │   ├── library/
│   │   │   ├── main/
│   │   │   │   ├── LibraryManagementSystem.java  # Main menu and entry point
│   │   │   ├── models/
│   │   │   │   ├── Book.java                     # Defines book attributes
│   │   │   ├── services/
│   │   │   │   ├── Library.java                  # Manages book operations
│── .gitignore
│── README.md
│── pom.xml (if using Maven)
│── .idea/ (IntelliJ settings)
│── out/ (Compiled files)
```

##  **Setup & Usage**  

### 1️. Clone the Repository  
```bash
git clone https://github.com/your-username/Library-Management-System.git
cd Library-Management-System
```

### 2️. Compile & Run  
```bash
javac -d out src/com/library/main/LibraryManagementSystem.java
java -cp out com.library.main.LibraryManagementSystem
```

##  **How to Use?**  
1. Run the application.  
2. Choose an option from the **main menu**:  
   - **Add a new book** (ID, Title, Author, Genre, Status)  
   - **View all books**  
   - **Search books** (by ID or Title)  
   - **Update book details**  
   - **Delete a book**  
3. The program will execute the selected operation and return to the menu.  


##  **License**  
This project is open-source.
