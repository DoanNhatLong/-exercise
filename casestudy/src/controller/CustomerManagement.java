package controller;

import service.CustomerService;
import service.ICustomerService;
import ultity.Helper;
import ultity.Menu;
import view.FuramaView;

import static controller.FuramaController.sc;

public class CustomerManagement extends Menu {
    private static final ICustomerService customerService=new CustomerService();
    public static void showMenu(){
        new CustomerManagement().showMenu("Customer");
    }

    @Override
    protected void handleAdd() {
       customerService.addPerson();
    }

    @Override
    protected void handleDisplay() {
        customerService.display();
    }

    @Override
    protected void handleEdit() {
        customerService.edit();
    }
}
