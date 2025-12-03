package service;

import entity.Customer;
import repository.CustomerRepository;
import repository.ICustomerRepository;
import ultity.Helper;
import view.FuramaView;

import java.util.List;

import static controller.FuramaController.sc;

public class CustomerService implements ICustomerService{
    private static final ICustomerRepository repoCustomer =new CustomerRepository();

    @Override
    public void display() {
        repoCustomer.display();
    }

    @Override
    public void addPerson() {
        Customer temp= FuramaView.inputCustomer();
        repoCustomer.addPerson(temp);
    }

    @Override
    public void edit() {
        Customer temp= FuramaView.inputCustomer();
        String id= Helper.inputString("Nhập ID");
        repoCustomer.edit(id,temp);
    }

    @Override
    public List<Customer> getAll() {
        return repoCustomer.getAll();
    }
}
