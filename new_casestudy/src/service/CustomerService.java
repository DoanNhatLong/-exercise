package service;

import repository.CustomerRepository;
import repository.ICustomerRepository;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void handleAdd() {
        customerRepository.handleAdd();

    }

    @Override
    public void handleDisplay() {
        customerRepository.handleDisplay();
    }

    @Override
    public void handleEdit() {
        customerRepository.handleEdit();
    }
}
