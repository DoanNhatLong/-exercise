package entity;

public class Answer {
    String idAnswer;
    String idQuestion;
    String result;
    boolean isCorrect;
    String trans;

    public Answer() {
    }

    public Answer(String idAnswer, String idQuestion, String result) {
        this.idAnswer = idAnswer;
        this.idQuestion = idQuestion;
        this.result = result;
    }

    public Answer(String idAnswer, String idQuestion, String result, String trans) {
        this(idAnswer, idQuestion, result);
        this.trans=trans;
    }


    public Answer(String idAnswer, String idQuestion, String result, boolean isCorrect) {
        this.idAnswer = idAnswer;
        this.idQuestion = idQuestion;
        this.result = result;
        this.isCorrect = isCorrect;
    }

    public String toCSV(){
        return getIdAnswer()+","+getIdQuestion()+","+getResult()+","+(getIsCorrect()?"Đúng":"Sai");
    }

    @Override
    public String toString() {
        return "Answer{" +
                "idAnswer='" + idAnswer + '\'' +
                ", idQuestion='" + idQuestion + '\'' +
                ", result='" + result + '\'' + "," +
                 trans + '\'' +
                '}';
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
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
