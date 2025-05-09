package com.university.controller;

//S20421

import com.university.dao.RegistrationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RegistrationDao registrationDao;

    @GetMapping("/courses")
    public String listCourses(Model model) {
        String sql = "SELECT * FROM courses";
        model.addAttribute("courses", jdbcTemplate.queryForList(sql));
        return "courses";
    }

    @PostMapping("/register/{courseId}")
    public String registerCourse(@PathVariable int courseId, @RequestParam int studentId) {
        registrationDao.registerStudentToCourse(studentId, courseId);
        return "redirect:/success";
    }
}
