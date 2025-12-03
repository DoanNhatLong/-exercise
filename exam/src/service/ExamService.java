package service;

import repository.IQuestionRepository;
import repository.QuestionRepository;

public class ExamService implements IExamService {
    IQuestionRepository questionRepository = new QuestionRepository();

    @Override
    public void handleAdd() {
        questionRepository.addQuestion();

    }

    @Override
    public void handleDisplay() {
        questionRepository.display();
    }
}
