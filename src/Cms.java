import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Cms {

    //LocalDateTime nowObject;
    ConcurrentHashMap<Integer, Course> courses;
    ConcurrentHashMap<Integer, Student> students;
    ArrayList<Registration> registrations;

    public Cms(){
        courses = new HashMap<>();
        students = new HashMap<>();
        registrations = new ArrayList<>();
    }

    public void addStudent(Student student){
        this.students.put(student.getID(), student);

    }

    public void addCourse(Course course){
        this.courses.put(course.getID(), course);
    }

    public void addRegistration(int studentID, int courseID){

        //check course availability
        synchronized(this) {
            if (courses.containsKey(courseID) && students.containsKey(studentID)) {

                if (courses.get(courseID).seatsAvailable > 0) {

                    if(students.get(studentID).coursesRegistered.contains(courseID))
                    {
                        System.out.println("reg failed  - you've already registered for this course");
                    }
                    LocalDateTime timestamp = LocalDateTime.now();
                    Registration r = new Registration(studentID, courseID, timestamp);
                    registrations.add(r);
                    System.out.println(students.get(studentID).getStudentName() + "registered to course" + courses.get(courseID).getCourseName() +
                            "at time: " + timestamp);

                    students.get(studentID).coursesRegistered.add(courseID);
                    courses.get(courseID).seatsAvailable--;

                } else System.out.println("sorry, seats are not available. Try next sem :(");
            }
        }
    }

    public void listCourses(){
        for(Course c : courses.values())
            System.out.println("Course ID: " + c.getID() + " Name: " + c.getCourseName());
    }

    public void listStudents(){
        for(Student s : students.values())
            System.out.println("Student ID: " + s.getID() + " Name: " + s.getStudentName());
    }

    public void listRegistrations(){
        for(Registration r : registrations)
            System.out.println("reg ID: " + r.registrationId + " Student with ID " + r.studentId + " registered to course" +
                    "with ID: " + r.courseId + " at time " + r.timestamp );
    }

    public void listStudentsforCourse(int courseID){
        System.out.println("Students registered for course " + courses.get(courseID).getCourseName());
        for(Registration r : registrations)
        {
            if (r.courseId == courseID)
            {
                System.out.println( "-" + students.get(r.studentId).getStudentName());
            }
        }
    }

    public void listCoursesforStudent(int studentID){

        if(!students.containsKey(studentID)) {
            System.out.println("Student with ID " + studentID + " not found");
            return;
        }

        System.out.println("Courses registered for student " + students.get(studentID).getStudentName());
        for(int id : students.get(studentID).coursesRegistered)
        {
            System.out.println("- " + id);
        }
    }

    public void searchCourseByID(int courseID){
        if(!courses.containsKey(courseID)) {
            System.out.println("Course with ID " + courseID + " not found");
            return;
        }
        System.out.println("course details:");
        System.out.println(" - Name: "+ courses.get(courseID).getCourseName() + " - instructor" +
                              courses.get(courseID).getInstructor()  );
    }

    public void searchCourseByName(String courseName){
        System.out.println("course details:");
        for(Course c : courses.values())
        {
            if(c.getCourseName().equalsIgnoreCase(courseName))
                System.out.println("- " + c.getCourseName() + " Instructor : " + c.getInstructor());
        }
    }
}
