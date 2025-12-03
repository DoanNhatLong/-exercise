package repository;

import entity.Answer;
import entity.Question;

import java.util.List;

public interface IQuestionRepository {
    void addQuestion();

    void display();

    List<Question> getAllQuestion();
    List<Answer> getAllAnswer();
}
