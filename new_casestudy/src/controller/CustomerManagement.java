package controller;

import service.CustomerService;
import service.ICustomerService;
import service.IEmployeeService;
import utils.Menu;

public class CustomerManagement extends Menu {
    ICustomerService customerService=new CustomerService();
    public static void showMenu() {
        new CustomerManagement().showMenu("Customer");
    }

    @Override
    protected void handleAdd() {
        customerService.handleAdd();
    }

    @Override
    protected void handleDisplay() {
        customerService.handleDisplay();
    }

    @Override
    protected void handleEdit() {
        customerService.handleEdit();
    }
}
