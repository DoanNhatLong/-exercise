package service;

import entity.Customer;
import entity.Employee;
import repository.EmployeeRepository;
import repository.IEmployeeRepository;
import ultity.Helper;
import view.FuramaView;

import java.util.List;

public class EmployeeService implements IEmployeeService{
    private static final IEmployeeRepository repoEmployee =new EmployeeRepository();

    @Override
    public void display() {
        repoEmployee.display();
    }

    @Override
    public void addPerson() {
        Employee temp=FuramaView.inputEmployee();
        repoEmployee.addPerson(temp);
    }

    @Override
    public void edit() {
        Employee temp=FuramaView.inputEmployee();
        String id=Helper.inputString("Nhập ID");
        repoEmployee.edit(id,temp);
    }

    @Override
    public List<Employee> getAll() {
        return repoEmployee.getAll();
    }
}
