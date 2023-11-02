package DAO;

import JPA.Teacher;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl extends DAO implements TeacherDao {

    public TeacherDaoImpl(){
        super();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        EntityManager entityManager = null;
        try{
            entityManager = factory.createEntityManager();
            Query query = entityManager.createNamedQuery("getAllTeachers");
            List<Teacher> teachersList = (List<Teacher>)query.getResultList();
            return teachersList;
        } finally{
            entityManager.close();
        }
    }

    @Override
    public Teacher getTeacherByName(String fullName){
        EntityManager entityManager = null;
        try{
            entityManager = factory.createEntityManager();
            Query query = entityManager.createNamedQuery("getTeacherByFullName");
            query.setParameter("teacherFullName",fullName);
            Teacher teacher = (Teacher)query.getSingleResult();
            return teacher;
        } finally{
            entityManager.close();
        }
    }

    @Override
    public List<Teacher> getMultipleCourseTeachers() {
        EntityManager entityManager = null;
        try{
            entityManager = factory.createEntityManager();
            Query query = entityManager.createNamedQuery("getTeachersWithMultipleCourses");
            List<Teacher> teachersList = (List<Teacher>)query.getResultList();
            return teachersList;
        } finally{
            entityManager.close();
        }
    }
}
