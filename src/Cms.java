import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;

public class Cms {

    //LocalDateTime nowObject;
    Map<Integer, Course> courses;
    Map<Integer, Student> students;
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
        if(courses.containsKey(courseID) && students.containsKey(studentID)){

            if(courses.get(courseID).seatsAvailable > 0)
            {
                LocalDateTime timestamp = LocalDateTime.now();
                Registration r = new Registration(studentID, courseID, timestamp);
                registrations.add(r);
                System.out.println(students.get(studentID).getStudentName() + "registered to course" + courses.get(courseID).getCourseName() +
                    "at time: " + timestamp);

                students.get(studentID).coursesRegistered.add(courseID);
                courses.get(courseID).seatsAvailable--;

            }
        }
    }
}
