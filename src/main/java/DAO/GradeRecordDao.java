package DAO;

import JPA.GradeRecord;

import java.util.List;

public interface GradeRecordDao {
    List<GradeRecord> getStudentGrades(String studentName);
}