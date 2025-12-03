package model.entity;

public class Student extends Person{
    double score;

    public Student() {
    }

    public Student(Person temp, double score){
        super(temp.getId(),temp.getName());
        this.score=score;
    }

    public Student(String id, String name, double score) {
        super(id, name);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                "} " ;
    }
}
