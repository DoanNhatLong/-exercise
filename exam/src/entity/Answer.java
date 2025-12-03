package entity;

public class Answer {
    String idAnswer;
    String idQuestion;
    String result;

    public Answer() {
    }

    public Answer(String idAnswer, String idQuestion, String result) {
        this.idAnswer = idAnswer;
        this.idQuestion = idQuestion;
        this.result = result;
    }

    public String toCSV(){
        return getIdAnswer()+","+getIdQuestion()+","+getResult();
    }

    @Override
    public String toString() {
        return "Answer{" +
                "idAnswer='" + idAnswer + '\'' +
                ", idQuestion='" + idQuestion + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public String getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(String idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
