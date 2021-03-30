package softeng.project.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softeng.project.main.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

}