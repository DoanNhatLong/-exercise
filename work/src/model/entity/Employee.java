package model.entity;

import java.util.ArrayList;

public class Employee extends ArrayList<Employee> {
    private String id;
    private String name;
    private int year;
    private String position;
    private double salary;

    public Employee() {
    }

    public Employee(String id, String name, int year, String position, double salary) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.position = position;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
