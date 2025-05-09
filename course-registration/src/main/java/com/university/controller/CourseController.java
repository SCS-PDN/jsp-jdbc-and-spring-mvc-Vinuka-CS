package com.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/courses")
    public String listCourses(Model model) {
        String sql = "SELECT * FROM courses";
        model.addAttribute("courses", jdbcTemplate.queryForList(sql));
        return "courses";
    }

    @PostMapping("/register/{courseId}")
    public String registerCourse(int studentId, int courseId) {
        String sql = "INSERT INTO registrations (student_id, course_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, studentId, courseId);
        return "redirect:/success";
    }
}

