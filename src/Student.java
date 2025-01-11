import java.util.ArrayList;

public class Student {
    private int studentID;
    private String studentName;
    public ArrayList<Integer> coursesRegistered;

    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.coursesRegistered = new ArrayList<>();
    }
    public int getID() {
        return studentID;
    }
    public String getStudentName(){
        return studentName;
    }

}
