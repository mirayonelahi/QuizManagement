package softeng.project.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import softeng.project.main.model.Question;
import softeng.project.main.service.QuizService;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@RestController
public class ApiController {
    @Autowired
    QuizService quizService;

    @GetMapping("/listAllQuestion")
    public Collection<Question> list() {
        return quizService.listAllQuestion();
    }

    @PostMapping("/apiaddquestion")
    public Question postBook(@RequestBody Question question){
        return  quizService.createBook(question);

    }

    @DeleteMapping("question/{id}")
    public void delete(@PathVariable Integer id) {

        quizService.deleteUser(id);
    }


}
