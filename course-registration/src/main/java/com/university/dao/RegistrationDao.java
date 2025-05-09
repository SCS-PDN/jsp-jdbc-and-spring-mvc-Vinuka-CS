package com.university.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void registerCourse(int studentId, int courseId) {
        String sql = "INSERT INTO registrations (student_id, course_id, date) VALUES (?, ?, NOW())";
        jdbcTemplate.update(sql, studentId, courseId);
    }
}
