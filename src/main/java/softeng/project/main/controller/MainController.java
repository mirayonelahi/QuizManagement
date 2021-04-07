package softeng.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @GetMapping("/")
    public String homePage() {
        return "home.html";
    }

    @GetMapping("/quiz")
    public String quiz() {
        return "quiz.html";

    }

    @PostMapping("/questions")
    public String questions(@RequestParam String username, Model m, RedirectAttributes ra) {
        if (username.equals("")) {
            ra.addFlashAttribute("warning", "You must enter your name");
            return "redirect:/quiz";
        }
        return "quiz.html";
    }
}

