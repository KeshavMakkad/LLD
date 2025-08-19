class Book {
    private String name;
    private String author;
    private String genre;
    private double rating;
    private int reviews;
    private double price;
    private int year;

    public Book(String name, String author, String genre, double rating, int reviews, double price, int year) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.reviews = reviews;
        this.price = price;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
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

    public void setAuthor(String author) {
        this.author = author;
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
                name, author, rating, reviews, price, year, genre);
    }
}