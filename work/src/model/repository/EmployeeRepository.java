package model.repository;

import model.entity.Designer;
import model.entity.Developer;
import model.entity.Employee;
import model.entity.Manager;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    static List<Designer> designerList = new ArrayList<>();
    static List<Developer> developerList = new ArrayList<>();
    static List<Manager> managerList = new ArrayList<>();
    public static List<ArrayList<? extends Employee>> employee = new ArrayList<>();

    static {
        Designer test1 = new Designer("12", "Hung", 2000, "Freelancer", 20000, "Java");
        Manager test2 = new Manager("12", "Vu", 2002, "Boss", 20000, "High");
        Manager test3 = new Manager("33", "Vun", 2002, "Boss", 20000, "High");
        designerList.add(test1);
        managerList.add(test2);
        managerList.add(test3);
        employee.add((ArrayList<? extends Employee>) designerList);
        employee.add((ArrayList<? extends Employee>) developerList);
        employee.add((ArrayList<? extends Employee>) managerList);
    }


    @Override
    public void addEmployee(Employee employee) {
        if (employee instanceof Designer) {
            designerList.add((Designer) employee);
        } else if (employee instanceof Developer) {
            developerList.add((Developer) employee);
        } else if (employee instanceof Manager) {
            managerList.add((Manager) employee);
        }
    }

    @Override
    public void displayEmployees(int type) {
        if (type != 0) {
            for (Employee employees : employee.get(type - 1)) {
                System.out.println(employees);
            }
        }
    }


    public List<ArrayList<? extends Employee>> getAll() {
        return employee;
    }

}
