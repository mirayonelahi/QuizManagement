package softeng.project.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softeng.project.main.model.Question;
import softeng.project.main.service.QuizService;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

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

    @PutMapping("question/{id}")
    public ResponseEntity<?> update(@RequestBody Question question, @PathVariable Integer id) {
        try {
            Question aa = quizService.getQuestion(id);
            question.setQuesId(id);
            quizService.saveQuestion(question);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("question/{id}")
    public void delete(@PathVariable Integer id) {

        quizService.deleteUser(id);
    }


}
