package DAO;

import JPA.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getAllTeachers();

    Teacher getTeacherByName(String fullName);
    List<Teacher> getMultipleCourseTeachers();
}
