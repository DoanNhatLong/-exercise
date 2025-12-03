package entity;

public class NormalPlayer {
    private String name;
    private String position;
    private int skill;
    private int salary;
    private String unique;

    public NormalPlayer() {
    }

    public NormalPlayer(String name, String position, int skill, int salary, String unique) {
        this.name = name;
        this.position = position;
        this.skill = skill;
        this.salary = salary;
        this.unique = unique;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSkill() {
        return skill;
    }

    public int getSalary() {
        return salary;
    }

    public String getUnique() {
        return unique;
    }


    @Override
    public String toString() {
        return "NormalPlayer{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", skill=" + skill +
                ", salary=" + salary +
                ", unique='" + unique + '\'' +
                ", style='" +
                '}';
    }
}
