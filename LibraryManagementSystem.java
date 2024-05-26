import java.util.ArrayList;
public class LibraryManagementSystem {

    private static ArrayList<Student> studentslist = new ArrayList<>();


    public  static ArrayList<Student> getStudentslist(){
        return  studentslist;
    }

    public static void addStudent(Student std){
        studentslist.add(std);
    }
    

}
