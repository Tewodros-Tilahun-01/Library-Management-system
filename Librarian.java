
import java.util.Objects;
import java.util.Scanner;

public class Librarian extends Person  {

    Scanner SC = new Scanner(System.in);



    Librarian(String name,String password) {
        super(name,password);
    }




    public static void addBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter serial number");
        String serial = sc.nextLine();
        boolean flag = true;
        for (Book book : Book.bookslist) {
            if (Objects.equals(book.getSerialNumber() , serial)) {
                flag = false;
                System.out.println("   !!! Book found with the same serial number !!!");
            }

        }
        if (flag) {
                String numPatt = "^[0-9]+$";
                System.out.println("Enter book name");
                String bookName = sc.nextLine();
                System.out.println("Enter author");
                String author = sc.nextLine();
                System.out.println("Enter publisher");
                String publisher = sc.nextLine();
                System.out.println("Enter the year: ");

                String year = sc.next();

                while (!year.matches(numPatt)) {
                    System.out.println("   !!! only integer allowed !!");
                    year = sc.nextLine();
                }
                int realyear = Integer.parseInt(year);

                Book book = new Book(serial, bookName, author, publisher, realyear);
                Book.bookslist.add(book);
                System.out.println("   !!! Book added successfully !!!  ");

        }
        System.out.print("Write anything and press to continue...... ");
        sc.next();
        UserInterface.librarianPage();
    }

    public static void showBook() {
        if (Book.bookslist.isEmpty()) {
            System.out.println("    !!! There is no book available !!!  ");
        } else {
            for (Book book :Book.bookslist) {

                System.out.println("The full information of book: ");
                System.out.println("*****************************************************");
                System.out.println("* Serial Number: " + book.getSerialNumber());
                System.out.println("* Book Name: " + book.getBookName());
                System.out.println("* Book Author: " + book.getAuthor());
                System.out.println("* Publisher: " + book.getPublisher());
                System.out.println("* Year of Edition: " + book.getYear());
                System.out.println("*****************************************************");
            }
        }
        System.out.print("Write anything and press to continue...... ");
        Scanner input = new Scanner(System.in);
        input.next();
        UserInterface.librarianPage();

    }

    public static void searchBook() {
        Scanner input = new Scanner(System.in);


        if (Book.bookslist.isEmpty()) {
            System.out.println("     !!! There is no book available !!!   ");
        } else {
            System.out.println("Enter the book seral number");
            String searchWord = input.next();
            boolean flag =false;
            for (Book book : Book.bookslist) {

                if (Objects.equals(searchWord, book.getSerialNumber())) {
                    System.out.println("The full information of book: ");
                    System.out.println("*****************************************************");
                    System.out.println("* Serial Number: " + book.getSerialNumber());
                    System.out.println("* Book Name: " + book.getBookName());
                    System.out.println("* Book Author: " + book.getAuthor());
                    System.out.println("* Publisher: " + book.getPublisher());
                    System.out.println("* Year of Edition: " + book.getYear());
                    System.out.println("*****************************************************");
                    flag = true;
                }

            }
            if (!flag){
                System.out.println("    !!! Book not found !!!");
            }
        }
        System.out.print("Write anything and press to continue...... ");
        input.next();
        UserInterface.librarianPage();

    }

    public static void deleteBook() {
        Scanner input = new Scanner(System.in);
        if (Book.bookslist.isEmpty()) {
            System.out.println("     !!! There is no book available !!!");
        } else {
            System.out.println("Enter the book serial number");
            String searchWord = input.next();
            boolean found = false;
            for (Book book :Book.bookslist) {
                if (Objects.equals(book.getSerialNumber(), searchWord)) {
                    Book.bookslist.remove(book);
                    System.out.println("     !!! Deleted successfully !!! ");
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println(" !!! Book not found !!!");

            }
        }
        System.out.print("Write anything and press to continue...... ");
        input.next();
        UserInterface.librarianPage();
    }
    public static void  addStudent(){
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        System.out.println("enter the name");
        if(LibraryManagementSystem.getStudentslist().isEmpty()){
            String stdName = input.nextLine();
            System.out.println("enter password");
            String password = input.next();
            Student student = new Student(stdName,password);
            LibraryManagementSystem.addStudent(student);
            System.out.println("student registered successfully");

            flag = false;
        }
        while (flag){

            String stdName = input.next();
            boolean found = true;
        for (Student std : LibraryManagementSystem.getStudentslist()) {
            if(Objects.equals(std.getName(), stdName)){
                System.out.println("Enter another valid name student name found");
                found = false;
                break;
            }
        }
          if(found){
                System.out.println("Enter password");
                String password = input.next();
                flag = false;
                Student student = new Student(stdName,password);
                LibraryManagementSystem.addStudent(student);
                System.out.println(" ___________ Student registered successfully!! _______");
                break;
            }
        }
        System.out.print("Write anything and press to continue...... ");
        input.next();
        UserInterface.librarianPage();

    }
    public  static  void showStudents(){
        Scanner input = new Scanner(System.in);
        if (LibraryManagementSystem.getStudentslist().isEmpty()){
            System.out.println("      !!! There is no students !!!");
        }else {
            System.out.println("------------------------------------------");
            for (Student std : LibraryManagementSystem.getStudentslist()) {
                System.out.println("name " + std.getName());
            }
            System.out.println("------------------------------------------");

        }
        System.out.print("Write anything and press to continue...... ");
        input.next();
        UserInterface.librarianPage();


    }


}


