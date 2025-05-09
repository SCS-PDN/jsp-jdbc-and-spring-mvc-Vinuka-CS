package com.university.dao;

import com.university.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {
    private JdbcTemplate jdbcTemplate;


    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Student getStudentByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM students WHERE email = ? AND password = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{email, password}, (rs, rowNum) ->
                new Student(rs.getInt("student_id"), rs.getString("name"), rs.getString("email"), rs.getString("password"))
        );
    }


    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Student(rs.getInt("student_id"), rs.getString("name"), rs.getString("email"), rs.getString("password"))
        );
    }
}
