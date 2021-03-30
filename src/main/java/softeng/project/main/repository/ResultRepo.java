package softeng.project.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softeng.project.main.model.Result;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {
	
}
