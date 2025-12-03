package repository;

import entity.Answer;
import entity.Question;
import ultity.Library;
import ultity.ReadAndWriteFile;
import ultity.UserException;

import java.util.ArrayList;
import java.util.List;

import static ultity.Helper.inputString;

public class QuestionRepository implements IQuestionRepository {
    public static String ANSWER_LIST = "src/data/answer.csv";
    public static String QUESTION_LIST = "src/data/question.csv";

    @Override
    public void addQuestion() {
        String idQuestion = inputString("Nhập mã câu hỏi (Q-XXX)");
        String content = inputString("Nhập nội dung câu hỏi");
        Question temp = new Question(idQuestion, content);
        List<String> stringListQuestion = new ArrayList<>();
        stringListQuestion.add(temp.toCSV());
        ReadAndWriteFile.write(QUESTION_LIST, stringListQuestion, true);
        List<Answer> answerList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            System.out.println("Nhập đáp án chp câu hỏi " + idQuestion);
            String idAnswer = Library.inputData(
                    () -> inputString("Nhập mã đáp án "),
                    (String string) -> UserException.validateID(string, idQuestion)
            );
            String result = inputString("Nhập nội dung đáp án" + i);
            answerList.add(new Answer(idAnswer, idQuestion, result, false));
        }
        while (true) {
            try {
                String correct = inputString("Nhập mã đáp án đúng");
                boolean flag = false;
                for (Answer answer : answerList) {
                    if (correct.contains(answer.getIdAnswer())) {
                        answer.setIsCorrect(true);
                        flag = true;
                    }
                }
                if (!flag) {
                    throw new UserException("Đáp án không trùng mã nào");
                }
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        List<Answer> answerListCSV = new ArrayList<>();
        for (Answer answer : answerList) {
            String trans = (answer.getIsCorrect() ? "Đúng" : "Sai");
            answerListCSV.add(new Answer(answer.getIdAnswer(), answer.getIdQuestion(), answer.getResult(), trans));
        }
        List<String> stringListAnswer = new ArrayList<>();

        for (Answer answer : answerListCSV) {
            stringListAnswer.add(answer.toCSV());
        }
        ReadAndWriteFile.write(ANSWER_LIST, stringListAnswer, true);

    }

    @Override
    public void display() {
        List<Question> questionList = getAllQuestion();
        List<Answer> answerList = getAllAnswer();
        for (int i = 0; i < questionList.size(); i++) {
            System.out.println(questionList.get(i));
            for (int j = 4 * i; j < 4 * (i + 1); j++) {
                System.out.println(answerList.get(j));
            }
        }
    }

    @Override
    public List<Question> getAllQuestion() {
        return Library.getAll(
                QUESTION_LIST,
                arr -> new Question(arr[0], arr[1])
        );
    }

    @Override
    public List<Answer> getAllAnswer() {
        List<String> stringList = ReadAndWriteFile.readFileCSVToStringList(ANSWER_LIST);
        List<Answer> answerList = new ArrayList<>();
        for (String string : stringList) {
            String[] arr = string.split(",");
            answerList.add(new Answer(arr[0], arr[1], arr[2], arr[3]));
        }
        return answerList;
    }

}
