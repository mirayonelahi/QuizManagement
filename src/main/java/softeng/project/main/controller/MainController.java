package softeng.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String homePage() {
        return "home.html";
    }
    @GetMapping("/quiz")
    public String quiz(){
            return "quiz.html";

        }
    }

