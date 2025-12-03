package model.entity;

public class Ministry extends Person{
    double salary;
    String area;

    public Ministry() {
    }

    public Ministry(Person temp, String area){
        super(temp.getId(),temp.getName());
        this.area=area;
    }

    public Ministry(String id, String name, double salary, String area) {
        super(id, name);
        this.salary = salary;
        this.area = area;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Ministry{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", area='" + area + '\'' +
                "} ";
    }
}
