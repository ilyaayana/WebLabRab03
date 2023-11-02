package DAO;
import JPA.GradeRecord;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GradeRecordDaoImpl extends DAO implements GradeRecordDao {

    public GradeRecordDaoImpl(){

        super();
    }

    @Override
    public List<GradeRecord> getStudentGrades(String studentName) {
        EntityManager entityManager = null;
        try{
            entityManager = factory.createEntityManager();
            Query query = entityManager.createNamedQuery("getAllGrades");
            query.setParameter("studentFullName",studentName);
            List<GradeRecord> gradesList = (List<GradeRecord>)query.getResultList();
            return gradesList;
        } finally{
            entityManager.close();
        }
    }
}
