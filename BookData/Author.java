import java.util.*;

public class Author {
    private String name;
    private List<Book> books;
    
    public Author(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    
    public Author(String name, List<Book> books) {
        this.name = name;
        this.books = new ArrayList<>(books);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
    
    public void addBook(Book book) {
        this.books.add(book);
    }
    
    public void addBooks(List<Book> books) {
        this.books.addAll(books);
    }
    
    public static int getTotalBooksByAuthor(String authorName, List<Book> books) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                count++;
            }
        }
        return count;
    }
    
    public static Set<String> getAllAuthors(List<Book> books) {
        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor().getName());
        }
        return authors;
    }
    
    public static List<String> getBooksByAuthor(String authorName, List<Book> books) {
        List<String> bookNames = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                bookNames.add(book.getName());
            }
        }
        return bookNames;
    }

    public static List<Book> getBooksWithPricesByAuthor(String authorName, List<Book> books) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }
}
