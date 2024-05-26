import java.util.Scanner;
import java.util.ArrayList;
public class Book  {
    private String name;

    private String author;
    private String publisher;
    private int year;
    private  String serialNumber;


    public static ArrayList<Book> bookslist = new ArrayList<>();



    Scanner SC = new Scanner(System.in);

    public Book(String serialNumber, String bookName, String author, String publisher, int year) {
        this.name = bookName;
        this.serialNumber = serialNumber;
        this.author = author;
        this.publisher = publisher;
        this.year = year;

    }


    public String getSerialNumber(){
        return this.serialNumber;
    }


    public String getBookName() {
        return this.name;
    }



    public String getAuthor() {
        return author;
    }



    public String getPublisher() {
        return publisher;
    }


    public int getYear() {
        return year;
    }



       
}
