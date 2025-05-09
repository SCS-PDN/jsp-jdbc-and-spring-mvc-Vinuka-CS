import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class CourseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/courses")
    public ModelAndView getCourses() {
        String sql = "SELECT * FROM courses";
        List<Map<String, Object>> courses = jdbcTemplate.queryForList(sql);
        ModelAndView modelAndView = new ModelAndView("courses");
        modelAndView.addObject("courses", courses);
        return modelAndView;
    }

    @PostMapping("/register/{courseId}")
    public String registerCourse(@PathVariable("courseId") int courseId) {
        int studentId = 1;
        String sql = "INSERT INTO registrations (student_id, course_id, date) VALUES (?, ?, NOW())";
        jdbcTemplate.update(sql, studentId, courseId);
        return "redirect:/success";
    }
}
