package entity;

public class Question {
    String idQuestion;
    String content;

    public Question() {
    }

    public Question(String idQuestion, String content) {
        this.idQuestion = idQuestion;
        this.content = content;
    }


    public String toCSV(){
        return getIdQuestion()+","+getContent();
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQuestion='" + idQuestion + '\'' +
                ", content='" + content + '\'' +
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

}
