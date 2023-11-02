package DAO;

import JPA.Course;
import JPA.Teacher;

import java.util.Date;
import java.util.List;

public interface CourseDao {
    public Long countStudentsOnCourse(String courseTitle);
    List<Course> getAllCourses();
    void openNewCourse(String courseName, String teacherName, Date startDate);
}
