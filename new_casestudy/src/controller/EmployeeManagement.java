package controller;

import service.EmployeeService;
import service.IEmployeeService;
import utils.Menu;

public class EmployeeManagement extends Menu {
    IEmployeeService employeeService=new EmployeeService();
    public static void showMenu() {
        new EmployeeManagement().showMenu("Employee");
    }

    @Override
    protected void handleAdd() {
        employeeService.handleAdd();
    }

    @Override
    protected void handleDisplay() {
        employeeService.handleDisplay();
    }

    @Override
    protected void handleEdit() {
        employeeService.handleEdit();
    }
}
