import java.time.LocalDateTime;

public class Registration {
    public static int counter = 0;
    public int registrationId;
    public int studentId;
    public int courseId;
    public LocalDateTime timestamp;

    public Registration(int studentId, int courseId, LocalDateTime timestamp) {
        this.registrationId = counter;
        this.studentId = studentId;
        this.courseId = courseId;
        this.timestamp = timestamp;
        counter++;
    }
}
