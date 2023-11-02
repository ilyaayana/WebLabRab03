package JPA;

import javax.persistence.*;

@Entity
@Table(name = "GradeRecords")
@NamedQuery(
        name = "getAllGrades",
        query = "select g from GradeRecord g where concat(g.student.firstName,' ',g.student.lastName) = :studentFullName"
)
public class GradeRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;

    private int grade;

    // Constructors

    public GradeRecord() {
    }

    public GradeRecord(Course course, Student student, int grade) {
        this.course = course;
        this.student = student;
        this.grade = grade;
    }

    // Getters and Setters

    public int getId() {

        return id;
    }

    public Course getCourse() {

        return course;
    }

    public void setCourse(Course course) {

        this.course = course;
    }

    public Student getStudent() {

        return student;
    }

    public void setStudent(Student student) {

        this.student = student;
    }

    public int getGrade() {

        return grade;
    }

    public void setGrade(int grade) {

        this.grade = grade;
    }


    @Override
    public String toString() {
        return "course:" + course.getTitle() + ", student:" + student.getFullName() + ", grade:" + grade;
    }
}