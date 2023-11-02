package JPA;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
@NamedQueries({
        @NamedQuery(
                name = "getAllTeachers",
                query = "SELECT t FROM Teacher t"
        ),
        @NamedQuery(
                name = "getTeacherByFullName",
                query = "select t from Teacher t where concat(t.firstName,' ',t.lastName) = :teacherFullName"
        ),
        @NamedQuery(
                name = "getTeachersWithMultipleCourses",
                query = "SELECT t FROM Teacher t " +
                        "JOIN Course c ON t.id = c.teacher.id " +
                        "GROUP BY t.id HAVING COUNT(c.id) > 1"
        )
}
)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    public Teacher() {
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }


    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public int getId() {

        return id;
    }


    @Override
    public String toString() {
        return  id + "." + getFullName();
    }
}

