import java.util.ArrayList;

public class Course {
    private int courseID;
    private String courseName;
    private String courseCode;
    private String instructor;
    public int seatsAvailable;
    private ArrayList<Student> students;

    public Course(int courseID, String courseName, String courseCode, String instructor, int maxCapacity) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructor = instructor;
        this.seatsAvailable = maxCapacity;
        this.students = new ArrayList<>();
    }
    public String getCode(Course course){
        return course.courseCode;
    }
    public int getID() {
        return this.courseID;
    }
    public String getCourseName() {
        return this.courseName;
    }
}
