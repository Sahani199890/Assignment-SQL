package com.example.Assignment.SQL.dao;

import com.example.Assignment.SQL.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface IStudent extends JpaRepository<StudentModel,Integer> {
    List<StudentModel> findByFirstName(String firstName);
    List<StudentModel> findByFirstNameAndLastName(String firstName,String lastName);
    StudentModel findByStudentId(Integer studentId);
    List<StudentModel> findByAgeAndFirstName(String firstName,Integer age);
    List<StudentModel> findByActive(boolean active);





    @Query(value = "select * from student_model where firstName=:firstName and lastName=:lastName",nativeQuery = true)
    public List<StudentModel> findByFirstNameAndLastName1(String firstName,String lastName);
    @Query(value = "select * from student_model where firstName=:firstName",nativeQuery = true)
    public List<StudentModel> findByFirstName1(String firstName);
    @Query(value = "select * from student_model where studentId=studentId",nativeQuery = true)
    StudentModel findByStudentId1(Integer studentId);
    @Query(value = "select * from student_model where age=age",nativeQuery = true)
    List<StudentModel> findByAge1(Integer age);

    @Query(value = "select * from student_model where firstName=:firstName AND age=:age",nativeQuery = true)
    List<StudentModel> findByAgeAndFirstName1(String firstName,Integer age);

    @Query(value = "select * from student_model where active=active",nativeQuery = true)
    List<StudentModel> findByActive1(boolean active);

    @Query(value = "select * from student_model where OrderBy age=age",nativeQuery = true)
    List<StudentModel> findAge(Integer age);


}
