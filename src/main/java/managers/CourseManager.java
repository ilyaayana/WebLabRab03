package managers;
import JPA.*;
import DAO.*;
import java.util.Date;
import java.util.*;


public class CourseManager {

    private static TeacherDaoImpl teacherDao;
    private static CourseDaoImpl courseDao;
    private static GradeRecordDaoImpl gradeRecordDao;

    public CourseManager() {
        teacherDao = new TeacherDaoImpl();
        courseDao = new CourseDaoImpl();
        gradeRecordDao = new GradeRecordDaoImpl();
    }

    public void printNumberOfStudentsCourse(String course_name)
    {
        System.out.println("Number of students of course " + course_name + ": "+courseDao.countStudentsOnCourse(course_name));
    }
    public void printAllCoursesInfo()
    {
        List<Course> courses =  courseDao.getAllCourses();
        for(Course course:courses){
            System.out.println(course.toString());
        }
    }
    public void printAllTeachers(){
        List<Teacher> teachers = teacherDao.getAllTeachers();
        System.out.println("Teachers with are:");
        for(Teacher teacher:teachers){
            System.out.println(teacher.toString());
        }
    }
    public void printTeachersWithMultipleCourses()
    {
        List<Teacher> teachers = teacherDao.getMultipleCourseTeachers();
        System.out.println("Teachers with multiple courses are:");
        for(Teacher teacher:teachers){
            System.out.println(teacher.toString());
        }
    }

    public void printStudentsGrades(String students_name){
        List<GradeRecord> gradeRecords = gradeRecordDao.getStudentGrades(students_name);
        System.out.println("Grades for student " + students_name + ":");
        for (GradeRecord gradeRecord:gradeRecords) {
            //System.out.println("Course: " + gradeRecord.getCourse().getTitle() + ", Grade: " + gradeRecord.getGrade());
            System.out.println(gradeRecord.toString());
        }
    }

    public void openNewCourse(String courseName,String teacherName, Date startDate){
        courseDao.openNewCourse(courseName,teacherName,startDate);
    }
}
