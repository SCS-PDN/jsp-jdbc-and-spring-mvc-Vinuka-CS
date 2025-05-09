package com.university.dao;

//S20421

import com.university.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao {
    private JdbcTemplate jdbcTemplate;


    public CourseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Course(rs.getInt("course_id"), rs.getString("name"), rs.getString("instructor"), rs.getInt("credits"))
        );
    }
}
