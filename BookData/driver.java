import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class driver {
    private List<Book> data;
    
    public driver() {
        this.data = new ArrayList<>();
    }
    
    public static void main(String[] args){
        driver bookAnalyzer = new driver();
        
        DataReader dataReader = new DataReader("bestsellers with categories.csv");
        bookAnalyzer.data = dataReader.readCSV();
        
        System.out.println("Loaded " + bookAnalyzer.data.size() + " books from dataset.\n");
        
        bookAnalyzer.testFunctions();
    }
    
    public void testFunctions() {
        System.out.println("=== Testing All Functions ===\n");
        
        System.out.println("1. Total books by George R. R. Martin: " + 
                          totalBooksByAuthor("George R. R. Martin", data));
        
        System.out.println("\n2. All authors in dataset:");
        getAllAuthors(data);
        
        System.out.println("\n3. Books by Stephen King:");
        getBooksByAuthor("Stephen King", data);
        
        System.out.println("\n4. Books with rating 4.8:");
        getBooksByRating(4.8, data);
        
        System.out.println("\n5. Prices of books by Fredrik Backman:");
        getPricesByAuthor("Fredrik Backman", data);
    }
    
    public static int totalBooksByAuthor(String authorName, List<Book> books) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                count++;
            }
        }
        return count;
    }
    
    public static void getAllAuthors(List<Book> books) {
        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        
        System.out.println("Total unique authors: " + authors.size());
        for (String author : authors) {
            System.out.println("- " + author);
        }
    }
    
    public static void getBooksByAuthor(String authorName, List<Book> books) {
        List<String> bookNames = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                bookNames.add(book.getName());
            }
        }
        
        if (bookNames.isEmpty()) {
            System.out.println("No books found for author: " + authorName);
        } else {
            System.out.println("Books by " + authorName + ":");
            for (String bookName : bookNames) {
                System.out.println("- " + bookName);
            }
        }
    }
    
    public static void getBooksByRating(double rating, List<Book> books) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (Math.abs(book.getRating() - rating) < 0.01) {
                matchingBooks.add(book);
            }
        }
        
        if (matchingBooks.isEmpty()) {
            System.out.println("No books found with rating: " + rating);
        } else {
            System.out.println("Books with rating " + rating + ":");
            for (Book book : matchingBooks) {
                System.out.println("- " + book.getName() + " by " + book.getAuthor());
            }
        }
    }
    
    public static void getPricesByAuthor(String authorName, List<Book> books) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                authorBooks.add(book);
            }
        }
        
        if (authorBooks.isEmpty()) {
            System.out.println("No books found for author: " + authorName);
        } else {
            System.out.println("Books and prices by " + authorName + ":");
            for (Book book : authorBooks) {
                System.out.printf("- %s: $%.2f\n", book.getName(), book.getPrice());
            }
        }
    }
}
