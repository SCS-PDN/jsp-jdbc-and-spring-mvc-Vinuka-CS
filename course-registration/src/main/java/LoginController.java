import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String password) {
        String sql = "SELECT * FROM students WHERE email = ? AND password = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, email, password);
        if (count > 0) {
            return "redirect:/courses";
        }
        return "login";
    }
}

