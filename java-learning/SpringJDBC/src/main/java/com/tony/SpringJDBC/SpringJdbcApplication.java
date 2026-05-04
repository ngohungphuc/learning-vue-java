package com.tony.SpringJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tony.SpringJDBC.model.Student;
import com.tony.SpringJDBC.service.StudentService;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

		Student s = context.getBean(Student.class);
		s.setRollNo(101);
		s.setName("John Doe");
		s.setMarks(85);

		StudentService studentService = context.getBean(StudentService.class);
		studentService.insertStudent(s);
	}

}
