package com.tony.SpringJDBC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tony.SpringJDBC.model.Student;
import com.tony.SpringJDBC.repo.StudentRepo;

@Service
public class StudentService {
    private StudentRepo studentRepo;

    public void insertStudent(Student s) {
        studentRepo.insertStudent(s);
    }

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }
}
