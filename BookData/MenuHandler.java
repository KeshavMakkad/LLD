import java.util.*;

public class MenuHandler {
    private List<Book> books;
    private Scanner scanner;
    
    public MenuHandler(List<Book> books) {
        this.books = books;
        this.scanner = new Scanner(System.in);
    }
    
    public void showMenu() {
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Total number of books by an author");
            System.out.println("2. Show all authors in the dataset");
            System.out.println("3. Show all books by an author");
            System.out.println("4. Show books by user rating");
            System.out.println("5. Show books and prices by an author");
            System.out.println("0. Exit");
            System.out.print("Enter your choice (0-5): ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                        handleTotalBooksByAuthor();
                        break;
                    case 2:
                        handleShowAllAuthors();
                        break;
                    case 3:
                        handleBooksByAuthor();
                        break;
                    case 4:
                        handleBooksByRating();
                        break;
                    case 5:
                        handleBooksPricesByAuthor();
                        break;
                    case 0:
                        System.out.println("Thank you for using the Book Dataset Application!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 0-5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
    
    private void handleTotalBooksByAuthor() {
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine().trim();
        
        if (authorName.isEmpty()) {
            System.out.println("Author name cannot be empty!");
            return;
        }
        
        int totalBooks = Author.getTotalBooksByAuthor(authorName, books);
        System.out.println("\nResult: " + authorName + " has " + totalBooks + " book(s) in the dataset.");
        
        if (totalBooks == 0) {
            System.out.println("Note: Author not found or no books by this author in the dataset.");
        }
    }
    
    private void handleShowAllAuthors() {
        Set<String> allAuthors = Author.getAllAuthors(books);
        
        System.out.println("\n=== All Authors in Dataset ===");
        System.out.println("Total unique authors: " + allAuthors.size());
        System.out.println("\nAuthors list:");
        
        List<String> sortedAuthors = new ArrayList<>(allAuthors);
        Collections.sort(sortedAuthors);
        
        for (int i = 0; i < sortedAuthors.size(); i++) {
            System.out.println((i + 1) + ". " + sortedAuthors.get(i));
        }
    }

    private void handleBooksByAuthor() {
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine().trim();
        
        if (authorName.isEmpty()) {
            System.out.println("Author name cannot be empty!");
            return;
        }
        
        List<String> bookNames = Author.getBooksByAuthor(authorName, books);
        
        System.out.println("\n=== Books by " + authorName + " ===");
        if (bookNames.isEmpty()) {
            System.out.println("No books found by this author in the dataset.");
        } else {
            System.out.println("Found " + bookNames.size() + " book(s):");
            for (int i = 0; i < bookNames.size(); i++) {
                System.out.println((i + 1) + ". " + bookNames.get(i));
            }
        }
    }
    
    private void handleBooksByRating() {
        System.out.print("Enter user rating (e.g., 4.7): ");
        
        try {
            double rating = scanner.nextDouble();
            scanner.nextLine();

            if (rating < 0 || rating > 5) {
                System.out.println("Rating should be between 0 and 5!");
                return;
            }
            
            List<Book> booksWithRating = Book.getBooksByRating(rating, books);
            
            System.out.println("\n=== Books with rating " + rating + " ===");
            if (booksWithRating.isEmpty()) {
                System.out.println("No books found with this exact rating.");
            } else {
                System.out.println("Found " + booksWithRating.size() + " book(s):");
                for (int i = 0; i < booksWithRating.size(); i++) {
                    Book book = booksWithRating.get(i);
                    System.out.println((i + 1) + ". " + book.getName() + " by " + book.getAuthor().getName());
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number for rating.");
            scanner.nextLine();
        }
    }
    
    private void handleBooksPricesByAuthor() {
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine().trim();
        
        if (authorName.isEmpty()) {
            System.out.println("Author name cannot be empty!");
            return;
        }
        
        List<Book> authorBooks = Author.getBooksWithPricesByAuthor(authorName, books);
        
        System.out.println("\n=== Books and Prices by " + authorName + " ===");
        if (authorBooks.isEmpty()) {
            System.out.println("No books found by this author in the dataset.");
        } else {
            System.out.println("Found " + authorBooks.size() + " book(s):");
            for (int i = 0; i < authorBooks.size(); i++) {
                Book book = authorBooks.get(i);
                System.out.println((i + 1) + ". " + book.getName() + " - $" + book.getPrice());
            }
            
            double totalPrice = 0.0;
            for (Book book : authorBooks) {
                totalPrice += book.getPrice();
            }
            System.out.println("\nTotal value of all books: $" + String.format("%.2f", totalPrice));
        }
    }
}
