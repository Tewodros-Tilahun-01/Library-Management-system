import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Student extends  Person{
    boolean login;
    ArrayList<Book> borrowedBooksList = new ArrayList<>();


    public Student(String name, String password) {
                super(name,password);
                this.login = false;

    }



public static  void showBook(String name){
    if (Book.bookslist.isEmpty()) {
        System.out.println("   !!! There is no book !!!  ");
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
    UserInterface.studentPage(name);
}
public static void showBorrowBook(String name){

        for (Student st: LibraryManagementSystem.getStudentslist()){
            if(st.login){
                showStBorrowBook(st);
                break;
            }
        }
    System.out.print("Write anything and press to continue...... ");
        Scanner input = new Scanner(System.in);
        input.next();
    UserInterface.studentPage(name);
}
public  static  void  showStBorrowBook(Student st){
        if(st.borrowedBooksList.isEmpty()){
            System.out.println("  !!! No book borrowed !!!");

    }
        for (Book book :st.borrowedBooksList){
            System.out.println("The full information of book:");
            System.out.println("*****************************************************");
            System.out.println("* Serial Number: " + book.getSerialNumber());
            System.out.println("* Book Name: " + book.getBookName());
            System.out.println("* Book Author: " + book.getAuthor());
            System.out.println("* Publisher: " + book.getPublisher());
            System.out.println("* Year of Edition: " + book.getYear());
            System.out.println("*****************************************************");
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Write anything and press to continue...... ");
        input.next();
        UserInterface.studentPage(st.getName());
}


    public static void borrow(String name){
        Scanner input = new Scanner(System.in);
        Book bk = null;
        if(Book.bookslist.isEmpty()){
            System.out.println("    !!! There is no book available !!!");
        }else {
            System.out.println("Enter serial number");
            String sn = input.next();
            boolean flag = false;
            for(Book book :Book.bookslist){
                if (Objects.equals(book.getSerialNumber(), sn)){

                    bk = book;
                    Book.bookslist.remove(book);
                    flag =true;
                    break;
                }
            }

            if(!flag){
                System.out.println("      !!! Book not found !!!");

            }
            else {
                for (Student st:LibraryManagementSystem.getStudentslist()){

                    if(st.login){

                        st.borrowedBooksList.add(bk);
                        System.out.println("    !!! Borrowed successfully !!!");

                        break;
                    }
                }

            }


        }
        System.out.print("Write anything and press to continue...... ");
        input.next();
        UserInterface.studentPage(name);

    }
public static void returnBorrow(String name){
        Scanner input = new Scanner(System.in);

    for (Student std : LibraryManagementSystem.getStudentslist()){
        if(std.login){
            if(std.borrowedBooksList.isEmpty()){
                System.out.println("   !!! No book borrowed !!!  ");
            }
            else{
                System.out.println("Enter the book serial number ");
                String sn = input.next();
                boolean found = false;
                for(Book book : std.borrowedBooksList){
                    if(Objects.equals(book.getSerialNumber(), sn)){
                        found = true;
                        Book.bookslist.add(book);
                        std.borrowedBooksList.remove(book);
                        System.out.println("   !!! Book returned to the library !!!");

                        break;
                    }
                }
                if(!found){
                    System.out.println(" !!! Book not found !!!");


                }

            }
            System.out.print("Write anything and press to continue...... ");
            input.next();
            UserInterface.studentPage(name);
        }

    }


}

}
