package repository;

import entity.Customer;
import entity.Customer;
import utils.Helper;
import utils.Library;
import utils.ReadAndWriteFile;
import view.PersonView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerRepository implements ICustomerRepository {
    private static final String CUSTOMER_LIST = "src/data/customer.csv";


    @Override
    public void handleAdd() {
        Customer temp = PersonView.inputCustomer();
        List<String> stringList = new ArrayList<>();
        stringList.add(temp.toCSV());
        ReadAndWriteFile.write(CUSTOMER_LIST, stringList, true);

    }

    @Override
    public void handleDisplay() {
        for (Customer customer : getAll()) {
            System.out.println(customer);
        }
    }

    @Override
    public void handleEdit() {
        String temp= Helper.inputString("Nhập tên muốn tìm");
        List<Customer> customerList=getAll();
        for (Customer customer : customerList) {
            if (Objects.equals(customer.getName(), temp)){
                String address=Helper.inputString("Nhập địa chỉ");
                customer.setAddress(address);
            }
        }
    }

    @Override
    public List<Customer> getAll() {
        return Library.getAll(
                CUSTOMER_LIST,
                arr->new Customer(arr[0],arr[1],arr[2],arr[3],arr[4],
                        arr[5],arr[6],arr[7],arr[8])
        );
    }
}
