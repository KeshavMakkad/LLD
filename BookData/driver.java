import java.util.*;

public class driver {
    public static void main(String[] args){
        DataReader dataReader = new DataReader("bestsellers with categories.csv");
        List<Book> books = dataReader.readCSV();
        
        System.out.println("=== Amazon Bestselling Books Dataset ===");
        System.out.println("Loaded " + books.size() + " books from dataset.\n");
        
        MenuHandler menuHandler = new MenuHandler(books);
        menuHandler.showMenu();
    }
}
