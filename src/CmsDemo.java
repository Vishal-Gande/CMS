import java.util.ArrayList;

public class CmsDemo {

    public static void main(String[] args) {
        Cms cms = new Cms();

        Course course = new Course(1,"oop", "CSF213", "Bhanu", 5);
        Course course2 = new Course(2, "os", "CSF214", "hota", 2);

        cms.addCourse(course);
        cms.addCourse(course2);

        Student s1 = new Student(1,"vish");
        Student s2 = new Student(2,"prav");
        Student s3 = new Student(3,"neethu");

        cms.addStudent(s1);
        cms.addStudent(s2);
        cms.addStudent(s3);

        cms.listCourses();
        cms.listStudents();

        cms.addRegistration(1,2);
        cms.addRegistration(2,2);
        cms.addRegistration(2,1);
        cms.listStudents();
        cms.listRegistrations();
        cms.listStudentsforCourse(2);
        cms.listCoursesforStudent(2);

        cms.searchCourseByID(2);
        cms.searchCourseByName("oop");
    }
}
