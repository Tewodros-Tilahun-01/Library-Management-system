import java.util.Objects;
import java.util.Scanner;

public class UserInterface {


    static void loginPage(){
        Scanner input = new Scanner(System.in);
        System.out.println("--------------- Welcome to My library ---------------");
        System.out.println("\t A) Login as a librarian");
        System.out.println("\t B) Login as a student");
        System.out.println("\t C) Exit");

            String option;
            System.out.print("\t choose: ");
            option = input.next();
            option = option.toUpperCase();
            switch(option){
                case "A":
                    UserInterface.librarianLogin();
                    break;
                case "B":
                    UserInterface.studentLoginPage();
                    break;
                case"C":
                    System.exit(0);
                default:
                    System.out.println("      !!! Invalid Option !!!   ");
                    loginPage();
            }

    }
    public static Librarian librarian = new Librarian("admin" ,"123");

    public static void librarianLogin() {
        boolean log = true;
        while (log){

            Scanner in = new Scanner(System.in);
            System.out.println("--------------- librarian Log In ---------------");
            System.out.print("\t Librarian Name: ");
            String userName = in.next();
            System.out.print("\t Password: ");
            String passowrd = in.next();
            if (userName.equals(librarian.getName()) && passowrd.equals(librarian.getPassword())) {
                System.out.println("        !!! you logged successfully !!!    ");
                log = false;
                UserInterface.librarianPage();
            } else {
                System.out.println("\t !!! Incorrect Username or Password !!! ");

            }
        }
    }
    public static void librarianPage(){
        Scanner in = new Scanner(System.in);
        System.out.println("  __________________________________________________");
        System.out.println("||                                                  ||");
        System.out.println("||      Press A to add book.                        ||");
        System.out.println("||      press B to show available books.            ||");
        System.out.println("||      Press C to Search book.                     ||");
        System.out.println("||      Press D to delete book.                     ||");
        System.out.println("||      Press E to add student                      ||");
        System.out.println("||      Press F to show student                     ||");
        System.out.println("||      Press G to log out from librarian account.  ||");
        System.out.println("||      Press H to Exit.                            ||");
        System.out.println("||__________________________________________________||");

            String option;
            System.out.print("\t choose: ");
            option = in.next();
            option = option.toUpperCase();
            switch(option){
                case "A":
                    Librarian.addBook();
                    break;
                case "B":
                    Librarian.showBook();
                    break;
                case "C":

                    Librarian.searchBook();
                    break;
                case "D":
                    Librarian.deleteBook();
                    break;
                case "E":
                    Librarian.addStudent();
                    break;
                case "F":
                    Librarian.showStudents();
                    break;
                case "G":
                    UserInterface.loginPage();
                    break;
                case "H":
                   System.exit(0);
                    break;
                default:
                    System.out.println("\tInvalid Option");
                    System.out.print("Write anything and press to continue..... ");
                    in.next();
                    librarianPage();
            }

    }
    public static  void studentLoginPage(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter student name");
        String name = in.nextLine();
        System.out.println("Enter student password");
        String password = in.next();
        boolean flag = false;
        for(Student std :LibraryManagementSystem.getStudentslist()){
            if (Objects.equals(std.getName(), name) && Objects.equals(std.getPassword(), password)){
                flag = true;
                std.login= true;
            }
        }
        if(flag){
            UserInterface.studentPage(name);
        }else {
            System.out.println("        !!! student not found !!!    ");
            System.out.print("Do you want to return to the main page (yes) : ");
            String op = in.next();
            if(op.equalsIgnoreCase("YES")){
                UserInterface.loginPage();
            }else{
                UserInterface.studentLoginPage();

            }
        }


    }

    static void studentPage(String name){
        System.out.println("___________ welcome back "+ name +" ___________________");
        System.out.println("  _____________________________________________________");
        System.out.println("||                                                     ||");
        System.out.println("||     Press A to show available books.                ||");
        System.out.println("||     Press B to show borrow books.                   ||");
        System.out.println("||     Press C to borrow book.                         ||");
        System.out.println("||     Press D to return book.                         ||");
        System.out.println("||     Press E to log out from student account.        ||");
        System.out.println("||     Press F to exit.                                ||");
        System.out.println("||_____________________________________________________||");

            Scanner in = new Scanner(System.in);
            String option;
            System.out.print("\t choose: ");
            option = in.next();
            option = option.toUpperCase();
            switch(option){
                case "A":
                    Student.showBook(name);
                    break;
                case "B":
                    Student.showBorrowBook(name);
                    break;
                case "C":
                    Student.borrow(name);
                    break;
                case"D":
                    Student.returnBorrow(name);
                    break;
                case "E":
                    UserInterface.logOutAll();
                    UserInterface.loginPage();
                    break;
                case "F":
                    System.exit(0);
                    break;
                default:
                    System.out.println("\tInvalid Option");
                    UserInterface.studentPage(name);
            }

    }

    public static  void logOutAll(){
        for(Student std: LibraryManagementSystem.getStudentslist()){
            std.login = false;
        }
    }
}
