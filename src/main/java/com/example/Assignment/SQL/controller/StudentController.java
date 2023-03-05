package com.example.Assignment.SQL.controller;

import com.example.Assignment.SQL.dao.IStudent;
import com.example.Assignment.SQL.model.StudentModel;
import com.example.Assignment.SQL.service.StudentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private IStudent iStudent;
    @PostMapping("/add-student")
    public ResponseEntity<StudentModel> addModel(@RequestBody String studentData){
        StudentModel studentModel=setData(studentData);
        StudentModel studentModel1 = studentService.addStudent(studentModel);
        return new ResponseEntity<>(studentModel1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/findStudentById-QueryMethod")
    public List<StudentModel> getbyfirstName(@RequestParam String firstName){
        return studentService.getStudentfirstname(firstName);
    }

    @GetMapping("/getStudentByFirst_and_last_name-QueryMethod")
    public List<StudentModel> findByFirstAndLastName(@RequestParam String firstName,@RequestParam String lastName){
        return studentService.findByFirstAndLastName(firstName,lastName);
    }

    @GetMapping("/get-studentById-QueryMethod")
    public StudentModel getstudentById(@RequestParam Integer studentId){
        return studentService.getstudentById(studentId);
    }
    @DeleteMapping("/deleteByStudentId-QueryMethod")
    public ResponseEntity<String> deleteStudent(@RequestParam Integer studentId){
        studentService.delete(studentId);
        return new ResponseEntity<>("Successful",HttpStatus.OK);
    }
    @GetMapping("/getStudentById-nativeQuery")
    public StudentModel getstudentById1(@RequestParam Integer studentId){
        return studentService.getstudentById1(studentId);
    }

    @GetMapping("/isStudentActive-nativeQuery")
    public List<StudentModel> isActive1(@RequestParam boolean active){
        return studentService.isActive(active);
    }
    @GetMapping("/studentByAge-nativeQuery")
    public List<StudentModel> studentbyAge(@RequestParam Integer age){
        return studentService.studentAge(age);
    }



    private StudentModel setData(String studentData) {
        JSONObject jsonObject=new JSONObject(studentData);
        StudentModel studentModel=new StudentModel();
//        studentModel.setStudentId(jsonObject.getInt("studentId"));
        studentModel.setAge(jsonObject.getInt("age"));
        studentModel.setActive(jsonObject.getBoolean("active"));
        studentModel.setLastName(jsonObject.getString("lastName"));
        studentModel.setFirstName(jsonObject.getString("firstName"));
        Timestamp createdDate=new Timestamp(System.currentTimeMillis());
        studentModel.setAdmissionDate(createdDate);
        return studentModel;
    }
}
