package controller;

import service.EmployeeService;
import service.IEmployeeService;
import ultity.Helper;
import ultity.Menu;

public class EmployeeManagement extends Menu {
    private static final IEmployeeService employeeService = new EmployeeService();

    public static void showMenu() {
        new EmployeeManagement().showMenu("Employee");
    }

    @Override
    protected void handleAdd() {
        employeeService.addPerson();
    }

    @Override
    protected void handleDisplay() {
        employeeService.display();
    }

    @Override
    protected void handleEdit() {
        employeeService.edit();
    }
}
