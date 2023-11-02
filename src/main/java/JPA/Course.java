package JPA;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
@NamedQueries({
        @NamedQuery(
                name = "findAllCourses",
                query = "SELECT c FROM Course c"
        ),
        @NamedQuery(
                name = "Course.findByTeacherName",
                query = "SELECT c FROM Course c WHERE c.teacher.lastName = :lastName"
        ),
        @NamedQuery(
                name = "getStudentsCountInCourse",
                query = "SELECT count(s) from Student s join s.courses c where c.title = :title"
        )
}
)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name="TITLE")
    private String title;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    @Temporal(TemporalType.DATE)
    private Date start_date;

    @Temporal(TemporalType.DATE)
    private Date end_date;

    //Constructors

    public Course() {
    }
    public Course(String title, Teacher teacher, Date start_date) {
        this.title = title;
        this.teacher = teacher;
        this.start_date = start_date;
    }
    public Course(String title, Teacher teacher, Date start_date, Date end_date) {
        this(title, teacher, start_date);
        this.end_date = end_date;
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = title;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course Title: ").append(title).append("\n");
        sb.append("Teacher: ").append(teacher.getFirstName() + " " + teacher.getLastName()).append("\n");
        sb.append("Start Date: ").append(start_date).append("\n");
        sb.append("End Date: ").append(end_date).append("\n");
        return sb.toString();
    }
}

