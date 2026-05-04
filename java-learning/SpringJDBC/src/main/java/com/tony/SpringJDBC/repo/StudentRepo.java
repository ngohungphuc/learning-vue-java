package com.tony.SpringJDBC.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tony.SpringJDBC.model.Student;

@Repository
public class StudentRepo {

    public void insertStudent(Student s) {
        System.out.println("Inserting student into DB: " + s);
    }

    public List<Student> getAllStudents() {
        System.out.println("Fetching all students from DB");
        return null;
    }

}
