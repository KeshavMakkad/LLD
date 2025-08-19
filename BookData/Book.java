import java.util.*;

class Book {
    private String name;
    private Author author;
    private String genre;
    private double rating;
    private int reviews;
    private double price;
    private int year;

    public Book(String name, Author author, String genre, double rating, int reviews, double price, int year) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.reviews = reviews;
        this.price = price;
        this.year = year;
    }
    
    public Book(String name, String authorName, String genre, double rating, int reviews, double price, int year) {
        this.name = name;
        this.author = new Author(authorName);
        this.genre = genre;
        this.rating = rating;
        this.reviews = reviews;
        this.price = price;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }
    
    public String getAuthorName() {
        return author.getName();
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public int getReviews() {
        return reviews;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public void setAuthor(String authorName) {
        this.author = new Author(authorName);
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void printDetails() {
        System.out.printf("Name: %s\nAuthor: %s\nRating: %.1f\nReviews: %d\nPrice: $%.2f\nYear: %d\nGenre: %s\n\n",
                name, author.getName(), rating, reviews, price, year, genre);
    }
    
    public static List<Book> getBooksByRating(double rating, List<Book> books) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (Math.abs(book.getRating() - rating) < 0.01) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }
}