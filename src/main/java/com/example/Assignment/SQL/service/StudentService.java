package com.example.Assignment.SQL.service;

import com.example.Assignment.SQL.dao.IStudent;
import com.example.Assignment.SQL.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private IStudent iStudent;

    public StudentModel addStudent(StudentModel studentModel) {
        return iStudent.save(studentModel);
    }

    public List<StudentModel> getStudentfirstname(String firstName) {
        return iStudent.findByFirstName(firstName);
    }
    public List<StudentModel> findByFirstAndLastName(String firstName,String lastName){
        return iStudent.findByFirstNameAndLastName(firstName,lastName);
    }

    public List<StudentModel> isActive(boolean active) {
        return iStudent.findByActive1(active);
    }

    public List<StudentModel> studentAge(Integer age) {
        return iStudent.findAge(age);
    }

    public StudentModel getstudentById(Integer studentId) {
        return iStudent.findByStudentId(studentId);
    }

    public StudentModel getstudentById1(Integer studentId) {
        return iStudent.findByStudentId1(studentId);
    }

    public void delete(Integer studentId) {
        iStudent.deleteById(studentId);
    }

}
