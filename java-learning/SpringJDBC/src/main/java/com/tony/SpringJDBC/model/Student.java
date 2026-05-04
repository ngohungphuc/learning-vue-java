package com.tony.SpringJDBC.model;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private int rollNo;

    private String name;
    private int marks;

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
    }
}
