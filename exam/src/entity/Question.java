package entity;

public class Question {
    String idQuestion;
    String content;
    Answer answer;


    public Question() {
    }

    public Question(String idQuestion, String content) {
        this.idQuestion = idQuestion;
        this.content = content;
    }

    public Question(String idQuestion, String content, Answer answer) {
        this.idQuestion = idQuestion;
        this.content = content;
        this.answer = answer;
    }

    public String toCSV(){
        return getIdQuestion()+","+getContent();
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQuestion='" + idQuestion + '\'' +
                ", content='" + content + '\'' +
                ", answer=" + answer +
                '}';
    }

    public String getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
