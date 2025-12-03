package model.entity;

public class Trainer extends Person{
    double salary;
    String tech;

    public Trainer() {
    }

    public Trainer(Person temp, String tech){
        super(temp.getId(),temp.getName());
        this.tech=tech;
    }

    public Trainer(String id, String name, double salary, String tech) {
        super(id, name);
        this.salary = salary;
        this.tech = tech;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", tech='" + tech + '\'' +
                "} ";
    }
}
