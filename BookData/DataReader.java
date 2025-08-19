import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DataReader {
    private String fileName;

    public DataReader(String fileName){
        this.fileName = fileName;
    }

    public List<Book> readCSV(){
        List<Book> books = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            // Skip header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Book book = parseLineToBook(line);
                if (book != null) {
                    books.add(book);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            e.printStackTrace();
        }
        return books;
    }
    
    private Book parseLineToBook(String line) {
        try {
            // Handle CSV parsing with quotes
            String[] parts = parseCSVLine(line);
            
            if (parts.length != 7) {
                System.err.println("Invalid line format: " + line);
                return null;
            }
            
            String name = parts[0].trim();
            String author = parts[1].trim();
            double rating = Double.parseDouble(parts[2].trim());
            int reviews = Integer.parseInt(parts[3].trim());
            double price = Double.parseDouble(parts[4].trim());
            int year = Integer.parseInt(parts[5].trim());
            String genre = parts[6].trim();
            
            return new Book(name, author, genre, rating, reviews, price, year);
            
        } catch (NumberFormatException e) {
            System.err.println("Error parsing numbers in line: " + line);
            return null;
        } catch (Exception e) {
            System.err.println("Error parsing line: " + line);
            return null;
        }
    }
    
    private String[] parseCSVLine(String line) {
        List<String> result = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder currentField = new StringBuilder();
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                result.add(currentField.toString());
                currentField = new StringBuilder();
            } else {
                currentField.append(c);
            }
        }
        
        result.add(currentField.toString());
        return result.toArray(new String[0]);
    }
}
