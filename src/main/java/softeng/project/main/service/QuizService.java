package softeng.project.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import softeng.project.main.model.Question;
import softeng.project.main.model.QuestionForm;
import softeng.project.main.model.Result;
import softeng.project.main.repository.QuestionRepo;
import softeng.project.main.repository.ResultRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    Question question;
    @Autowired
    QuestionForm qForm;
    @Autowired
    QuestionRepo qRepo;
    @Autowired
    Result result;
    @Autowired
    ResultRepo rRepo;

    public QuestionForm getQuestions() {
        List<Question> allQues = qRepo.findAll();
        List<Question> qList = new ArrayList<Question>();

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int rand = random.nextInt(allQues.size());
            qList.add(allQues.get(rand));
            allQues.remove(rand);
        }

        qForm.setQuestions(qList);

        return qForm;
    }

    public QuestionForm getAllQuestionsUi() {
        List<Question> allQues = qRepo.findAll();
        qForm.setQuestions(allQues);

        return qForm;
    }


    public int getResult(QuestionForm qForm) {
        int correct = 0;

        for (Question q : qForm.getQuestions())
            if (q.getAns() == q.getChose())
                correct++;

        return correct;
    }

    public void saveScore(Result result) {
        Result saveResult = new Result();
        saveResult.setUsername(result.getUsername());
        saveResult.setTotalCorrect(result.getTotalCorrect());
        rRepo.save(saveResult);
    }

    public List<Result> getTopScore() {
        List<Result> sList = rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));

        return sList;
    }


    public void saveQuestion(Question question) {
        this.qRepo.save(question);
    }

    public Collection<Question> listAllQuestion() {
        Collection<Question> allQues = qRepo.findAll();
        return allQues;

    }


    public Question createBook(Question question) {
        return qRepo.save(question);
    }

    public void deleteUser(Integer id) {
        qRepo.deleteById(id);
    }

    public Question getQuestion(Integer id) {
        return qRepo.findById(id).get();
    }
}
