package com.tony.SpringJDBC.service;

import org.springframework.stereotype.Service;

import com.tony.SpringJDBC.model.Student;

@Service
public class StudentService {

    public void insertStudent(Student s) {
        System.out.println("Inserting student: " + s);
    }

}
