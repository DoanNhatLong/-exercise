package model.repository;

import model.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public interface IEmployeeRepository {
    void addEmployee(Employee employee);
    void displayEmployees(int type);
    List<ArrayList<? extends Employee>> getAll();



}
