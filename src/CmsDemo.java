import java.util.ArrayList;

public class CmsDemo {

    public static void main(String[] args) {
        Cms cms = new Cms();

        Course course = new Course(1,"oop", "CSF213", "Bhanu", 5);
        Course course2 = new Course(2, "os", "CSF214", "hota", 4);

        cms.addCourse(course);
        cms.addCourse(course2);

        Student s1 = new Student(1,"vish");
        Student s2 = new Student(2,"prav");
        Student s3 = new Student(3,"neethu");

        cms.addStudent(s1);
        cms.addStudent(s2);
        cms.addStudent(s3);

        cms.addRegistration(1,2);


    }
}
