package entity;


public class Employee extends Person{
    private String idEmployee;
    private String level;
    private String position;
    double wage;

    public Employee() {
    }

    public Employee(String name, String date, String gender, String idPerson, String tel, String email, String idEmployee, String level, String position, double wage) {
        super(name, date, gender, idPerson, tel, email);
        this.idEmployee = idEmployee;
        this.level = level;
        this.position = position;
        this.wage = wage;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", name='" + name + '\'' +
                ", idPerson='" + idPerson + '\'' +
                ", gender='" + gender + '\'' +
                "} " ;
    }

    public String toCSV() {
        return name + "," +date + "," +gender + "," +idPerson + ","+tel
                + "," +email+","+idEmployee+"," +level+ "," +position + ","+wage;
    }
}
