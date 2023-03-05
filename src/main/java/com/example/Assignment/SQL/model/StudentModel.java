package com.example.Assignment.SQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_model")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentId")
    private int studentId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "age")
    private int age ;
    @Column(name = "active")
    private Boolean active ;
    @Column(name = "admissionDate")
    private Timestamp admissionDate;
}
