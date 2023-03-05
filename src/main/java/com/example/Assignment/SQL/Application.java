package com.example.Assignment.SQL;

import com.example.Assignment.SQL.dao.IStudent;
import com.example.Assignment.SQL.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private IStudent iStudent;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		StudentModel studentModel=new StudentModel();
//		studentModel.setActive(true);
//		studentModel.setAge(21);
//		studentModel.setStudentId(1);
//		studentModel.setAdmissionDate(new Timestamp(System.currentTimeMillis()));
//		studentModel.setFirstName("Abhishek");
//		studentModel.setLastName("Sahani");
//		iStudent.save(studentModel);
	}
}
