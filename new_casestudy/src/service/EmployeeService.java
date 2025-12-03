package service;

import repository.EmployeeRepository;
import repository.IEmployeeRepository;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public void handleAdd() {
        employeeRepository.handleAdd();
    }

    @Override
    public void handleDisplay() {
        employeeRepository.handleDisplay();
    }

    @Override
    public void handleEdit() {
        employeeRepository.handleEdit();
    }
}
