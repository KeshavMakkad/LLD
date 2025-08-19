import java.util.*;

public class driver {
    private List<Book> books;
    
    public driver() {
        this.books = new ArrayList<>();
    }
    
    public static void main(String[] args){
        driver app = new driver();
        
        DataReader dataReader = new DataReader("bestsellers with categories.csv");
        app.books = dataReader.readCSV();
        
        System.out.println("Loaded " + app.books.size() + " books from dataset.\n");
        
        BookTest.testAllFunctions(app.books);
    }
    
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
}
