package softeng.project.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softeng.project.main.model.Question;
import softeng.project.main.model.QuestionForm;
import softeng.project.main.model.Result;
import softeng.project.main.service.QuizService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    Result result;
    @Autowired
    QuizService qService;

    Boolean submitted = false;

    @ModelAttribute("result")
    public Result getResult() {
        return result;
    }

    @GetMapping("/")
    public String homePage() {
        return "home.html";
    }

    @GetMapping("/quiz")
    public String quiz() {
        return "quiz.html";

    }

    @GetMapping("/addQuestion")
    public String addQuestion(Model model) {
        // create model attribute to bind form data
        Question question = new Question();
        model.addAttribute("question", question);
        return "addQuestion";
    }



    @PostMapping("/saveQuestion")
    public String saveEmployee(@ModelAttribute("question") Question question) {
        // save employee to database
        qService.saveQuestion(question);
        return "redirect:/addQuestion";
    }

    @GetMapping("/allquestionui")
    public String allquestionui(Model model) {
        // create model attribute to bind form data
        QuestionForm qForm = qService.getAllQuestionsUi();
        model.addAttribute("qForm", qForm);
        return "all_questions";
    }

    @PostMapping("/questions")
    public String questions(@RequestParam String username, Model m, RedirectAttributes ra) {
        if (username.equals("")) {
            ra.addFlashAttribute("warning", "You must enter your name");
            return "redirect:/quiz";
        }

        submitted = false;
        result.setUsername(username);
        QuestionForm qForm = qService.getQuestions();
        m.addAttribute("qForm", qForm);

        return "questions.html";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute QuestionForm qForm, Model m) {
        if(!submitted) {
            result.setTotalCorrect(qService.getResult(qForm));
            qService.saveScore(result);
            submitted = true;
        }

        return "result.html";
    }

    @GetMapping("/score")
    public String score(Model m) {
        List<Result> sList = qService.getTopScore();
        m.addAttribute("sList", sList);

        return "leaderboard.html";
    }
}

