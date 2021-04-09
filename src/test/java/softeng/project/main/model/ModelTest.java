package softeng.project.main.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void questionModeltest() {
        //Arrange
        Question question = new Question();
        //Act
        question.setTitle("What does the expression float a = 35 / 0 return?");
        //Assert
        assertEquals("What does the expression float a = 35 / 0 return?", question.getTitle());

        question.setOptionA("0");
        question.setOptionB("exception");
        question.setOptionC("not a number");

        assertEquals("0", question.getOptionA());
        assertEquals("exception", question.getOptionB());
        assertEquals("not a number", question.getOptionC());


    }

    @Test
    void resultModelTest() {
        //Arrange
        Result result = new Result();
        //Act
        result.setUsername("ayon");
        //Assert
        assertEquals("ayon", result.getUsername());

        result.setTotalCorrect(4);

        assertEquals(4, result.getTotalCorrect());


    }

}