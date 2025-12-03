package model.entity;

public class Manager extends Employee{
    String skill;



    public Manager() {
    }

    public Manager(String id, String name, int year, String position, double salary, String skill) {
        super(id, name, year, position, salary);
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "skill='" + skill + '\'' +
                "} " + super.toString();
    }
}
