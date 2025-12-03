package model.service;

import model.entity.Employee;
import model.repository.EmployeeRepository;
import model.repository.IEmployeeRepository;

import java.util.ArrayList;
import java.util.Objects;


public class EmployeeService implements IEmployeeService {
    public static final IEmployeeRepository repo = new EmployeeRepository();

    public static void findByID(String id) {
        boolean found = false;
        for (ArrayList<? extends Employee> employees : repo.getAll()) {
            for (Employee employee : employees) {
                if (employee.getId().contains(id)) {
                    System.out.println(employee);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy");
        }

    }

    public static void deleteEmployee(String id) {
        boolean removed = false;
        for (ArrayList<? extends Employee> employees : repo.getAll()) {
            boolean temp = employees.removeIf(element -> Objects.equals(element.getId(), id));
            if (temp) {
                removed = true;
            }
        }
        if (removed) {
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Không có ID nào trùng");
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        repo.addEmployee(employee);
    }

    @Override
    public void displayEmployee(int input) {
        repo.displayEmployees(input);
    }


}

