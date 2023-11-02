package DAO;

import JPA.Course;
import JPA.Teacher;
import managers.CourseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class CourseDaoImpl extends DAO implements CourseDao {

    public CourseDaoImpl(){
        super();
    }

    @Override
    public Long countStudentsOnCourse(String courseTitle) {
        EntityManager entityManager = null;
        try{
            entityManager = factory.createEntityManager();
            Query query = entityManager.createNamedQuery("getStudentsCountInCourse");
            query.setParameter("title",courseTitle);
            Long count = (Long)query.getSingleResult();
            return count;
        } finally{
            entityManager.close();
        }
    }

    @Override
    public List<Course> getAllCourses() {
        EntityManager entityManager = null;
        try{
            entityManager = factory.createEntityManager();
            Query query = entityManager.createNamedQuery("findAllCourses");
            List<Course> courseList = (List<Course>)query.getResultList();
            return courseList;
        } finally{
            entityManager.close();
        }
    }

    @Override
    public void openNewCourse(String courseName, String teacherName, Date startDate) {
        EntityManager entityManager = null;
        try{
            entityManager = factory.createEntityManager();

            TeacherDaoImpl teacherDao = new TeacherDaoImpl();
            Teacher teacher = teacherDao.getTeacherByName(teacherName);
            Course course = new Course(courseName,teacher,startDate);

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(course);
            transaction.commit();
        } finally{
            entityManager.close();
        }
    }
}
