package model.entity;

public class Developer extends  Employee{
    String programing;

    public Developer() {
    }


    public Developer(String id, String name, int year, String position, double salary, String programing) {
        super(id, name, year, position, salary);
        this.programing = programing;
    }

    public String getPrograming() {
        return programing;
    }

    public void setPrograming(String programing) {
        this.programing = programing;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "programing='" + programing + '\'' +
                "} " + super.toString();
    }
}
