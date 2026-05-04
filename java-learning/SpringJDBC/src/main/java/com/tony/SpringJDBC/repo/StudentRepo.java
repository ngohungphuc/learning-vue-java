package com.tony.SpringJDBC.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.spi.DirStateFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tony.SpringJDBC.model.Student;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public void insertStudent(Student s) {
        String sql = "insert into student (rollno, name, marks) values (?, ?, ?)";
        int row = jdbc.update(sql, s.getRollNo(), s.getName(), s.getMarks());
        System.out.println("Inserted " + row + " row(s) for student: " + s);
    }

    public List<Student> getAllStudents() {
        String sql = "select * from student";
        RowMapper<Student> rowMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setRollNo(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
            }
        };
        return jdbc.query(sql, rowMapper);
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}
