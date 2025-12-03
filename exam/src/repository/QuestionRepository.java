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
        String idAnswer1= Library.inputData(
                ()->inputString("Nhập mã đáp án 1 "),
                (String string)->UserException.validateID(string,idQuestion)
        );
        String result1 = inputString("Nhaapj nội dung đáp án 1");
        String idAnswer2= Library.inputData(
                ()->inputString("Nhập mã đáp án 2 "),
                (String string)->UserException.validateID(string,idQuestion)
        );
        String result2 = inputString("Nhaapj nội dung đáp án 2");
        String idAnswer3= Library.inputData(
                ()->inputString("Nhập mã đáp án 3 "),
                (String string)->UserException.validateID(string,idQuestion)
        );
        String result3 = inputString("Nhaapj nội dung đáp án 3");
        String idAnswer4= Library.inputData(
                ()->inputString("Nhập mã đáp án 4 "),
                (String string)->UserException.validateID(string,idQuestion)
        );
        String result4 = inputString("Nhập nội dung đáp án 4");
        String correct = Library.inputData(
                ()->inputString("Nhập đáp án đúng"),
                (String str) ->UserException.validateCorrect(str,idAnswer1,idAnswer2,idAnswer3,idAnswer4)
        );
        Answer answer1 = new Answer(idAnswer1, idQuestion, result1);
        Answer answer2 = new Answer(idAnswer2, idQuestion, result2);
        Answer answer3 = new Answer(idAnswer3, idQuestion, result3);
        Answer answer4 = new Answer(idAnswer4, idQuestion, result4);
        List<String> stringListAnswer = new ArrayList<>();
        if (correct.contains(answer1.getIdAnswer())) {
            stringListAnswer.add(answer1.toCSV() + ",Đúng");
        } else {
            stringListAnswer.add(answer1.toCSV()+ ",Sai");
        }
        if (correct.contains(answer2.getIdAnswer())) {
            stringListAnswer.add(answer2.toCSV() + ",Đúng");
        } else {
            stringListAnswer.add(answer2.toCSV() + ",Sai");
        }
        if (correct.contains(answer3.getIdAnswer())) {
            stringListAnswer.add(answer3.toCSV() + ",Đúng");
        } else {
            stringListAnswer.add(answer3.toCSV() + ",Sai");
        }
        if (correct.contains(answer4.getIdAnswer())) {
            stringListAnswer.add(answer4.toCSV() + ",Đúng");
        } else {
            stringListAnswer.add(answer4.toCSV() + ",Sai");
        }

        ReadAndWriteFile.write(ANSWER_LIST, stringListAnswer, true);

    }

    @Override
    public void display() {
        List<Question> questionList=getAllQuestion();
        List<Answer> answerList=getAllAnswer();
        for (int i = 0; i < questionList.size() ; i++) {
            System.out.println(questionList.get(i));
            for (int j = 4*i; j < 4*(i+1); j++) {
                System.out.println(answerList.get(j));
            }
        }
    }

    @Override
    public List<Question> getAllQuestion() {
        return Library.getAll(
                QUESTION_LIST,
                arr->new Question(arr[0],arr[1])
        );
    }

    @Override
    public List<Answer> getAllAnswer() {
        List<String> stringList=ReadAndWriteFile.readFileCSVToStringList(ANSWER_LIST);
        List<Answer> answerList=new ArrayList<>();
        for (String string : stringList) {
            String [] arr=string.split(",");
            answerList.add(new Answer(arr[0],arr[1],arr[2]));
        }
        return answerList;
    }

}
