import java.util.*;

public class BookTest {
    
    public static void testAllFunctions(List<Book> books) {
        System.out.println("=== Testing Required Functions ===\n");
        
        testTotalBooksByAuthor(books);
        
        testGetAllAuthors(books);
        
        testBooksByAuthor(books);
        
        testBooksByRating(books);
        
        testPricesByAuthor(books);
    }
    
    public static void testTotalBooksByAuthor(List<Book> books) {
        System.out.println("=== Test 1: Total Books by Author ===");
        
        String[] testAuthors = {"George R. R. Martin", "Stephen King", "J. K. Rowling", "Rick Riordan"};
        
        for (String authorName : testAuthors) {
            int totalBooks = Author.getTotalBooksByAuthor(authorName, books);
            System.out.println("Total books by " + authorName + ": " + totalBooks);
        }
        System.out.println();
    }
    
    public static void testGetAllAuthors(List<Book> books) {
        System.out.println("=== Test 2: All Authors in Dataset ===");
        
        Set<String> allAuthors = Author.getAllAuthors(books);
        System.out.println("Total unique authors: " + allAuthors.size());
        
        System.out.println("Sample authors (first 10):");
        int count = 0;
        for (String author : allAuthors) {
            if (count < 10) {
                System.out.println("- " + author);
                count++;
            } else {
                break;
            }
        }
        System.out.println("... and " + (allAuthors.size() - 10) + " more authors\n");
    }
    
    public static void testBooksByAuthor(List<Book> books) {
        System.out.println("=== Test 3: Books by Author ===");
        
        String[] testAuthors = {"Stephen King", "J. K. Rowling", "Rick Riordan"};
        
        for (String authorName : testAuthors) {
            System.out.println("Books by " + authorName + ":");
            List<String> booksByAuthor = Author.getBooksByAuthor(authorName, books);
            if (booksByAuthor.isEmpty()) {
                System.out.println("No books found for author: " + authorName);
            } else {
                for (String bookName : booksByAuthor) {
                    System.out.println("- " + bookName);
                }
            }
            System.out.println();
        }
    }
    
    public static void testBooksByRating(List<Book> books) {
        System.out.println("=== Test 4: Books by Rating ===");
        
        double[] testRatings = {4.8, 4.7, 4.9, 3.5};
        
        for (double targetRating : testRatings) {
            System.out.println("Books with rating " + targetRating + ":");
            List<Book> booksByRating = Book.getBooksByRating(targetRating, books);
            if (booksByRating.isEmpty()) {
                System.out.println("No books found with rating: " + targetRating);
            } else {
                System.out.println("Found " + booksByRating.size() + " books:");
                int count = 0;
                for (Book book : booksByRating) {
                    if (count < 5) {
                        System.out.println("- " + book.getName() + " by " + book.getAuthor().getName());
                        count++;
                    } else {
                        break;
                    }
                }
                if (booksByRating.size() > 5) {
                    System.out.println("... and " + (booksByRating.size() - 5) + " more books");
                }
            }
            System.out.println();
        }
    }
    
    public static void testPricesByAuthor(List<Book> books) {
        System.out.println("=== Test 5: Books and Prices by Author ===");
        
        String[] testAuthors = {"Fredrik Backman", "George R. R. Martin", "Dr. Seuss", "Jeff Kinney"};
        
        for (String authorName : testAuthors) {
            System.out.println("Books and prices by " + authorName + ":");
            List<Book> booksWithPrices = Author.getBooksWithPricesByAuthor(authorName, books);
            if (booksWithPrices.isEmpty()) {
                System.out.println("No books found for author: " + authorName);
            } else {
                double totalPrice = 0.0;
                for (Book book : booksWithPrices) {
                    System.out.printf("- %s: $%.2f\n", book.getName(), book.getPrice());
                    totalPrice += book.getPrice();
                }
                System.out.printf("Total value of all books: $%.2f\n", totalPrice);
            }
            System.out.println();
        }
    }
    
    public static void runQuickDemo(List<Book> books) {
        System.out.println("=== Quick Demo ===\n");
        
        String authorName = "George R. R. Martin";
        int totalBooks = Author.getTotalBooksByAuthor(authorName, books);
        System.out.println("1. Total books by " + authorName + ": " + totalBooks);
        
        System.out.println("\n2. Sample authors (first 5):");
        Set<String> allAuthors = Author.getAllAuthors(books);
        int count = 0;
        for (String author : allAuthors) {
            if (count < 5) {
                System.out.println("- " + author);
                count++;
            } else {
                break;
            }
        }
        
        String authorName2 = "Stephen King";
        System.out.println("\n3. Books by " + authorName2 + ":");
        List<String> booksByAuthor = Author.getBooksByAuthor(authorName2, books);
        for (String bookName : booksByAuthor) {
            System.out.println("- " + bookName);
        }
        
        double targetRating = 4.8;
        System.out.println("\n4. Sample books with rating " + targetRating + " (first 3):");
        List<Book> booksByRating = Book.getBooksByRating(targetRating, books);
        count = 0;
        for (Book book : booksByRating) {
            if (count < 3) {
                System.out.println("- " + book.getName() + " by " + book.getAuthor().getName());
                count++;
            } else {
                break;
            }
        }
        
        String authorName3 = "Fredrik Backman";
        System.out.println("\n5. Books and prices by " + authorName3 + ":");
        List<Book> booksWithPrices = Author.getBooksWithPricesByAuthor(authorName3, books);
        for (Book book : booksWithPrices) {
            System.out.printf("- %s: $%.2f\n", book.getName(), book.getPrice());
        }
    }
}
