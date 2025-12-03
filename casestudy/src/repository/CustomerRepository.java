package repository;

import entity.Customer;
import ultity.Helper;
import ultity.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerRepository implements ICustomerRepository {
    final static String CUSTOMER_LIST = "src/data/customer.csv";


    @Override
    public void display() {
        List<Customer> customerList = getAll();
        Helper.display(customerList);
    }

    @Override
    public void addPerson(Customer temp) {
        List<String> stringList = new ArrayList<>();
        stringList.add(temp.toCSV());
        ReadAndWriteFile.write(CUSTOMER_LIST, stringList, true);
    }

    @Override
    public void edit(String id, Customer temp) {
        boolean flag = false;
        List<Customer> customerList = getAll();
        for (int i = 0; i < customerList.size(); i++) {
            if (Objects.equals(customerList.get(i).getIdCustomer(), id)) {
                customerList.set(i, temp);
                flag = true;
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Customer customer : customerList) {
            stringList.add(customer.toCSV());
        }
        ReadAndWriteFile.write(CUSTOMER_LIST, stringList, false);
        System.out.println(flag ? "Đã sửa thành công" : "Không có id trùng");
    }

    @Override
    public List<Customer> getAll() {
        List<String> stringList = ReadAndWriteFile.readFileCSVToStringList(CUSTOMER_LIST);
        List<Customer> customerList = new ArrayList<>();
        for (String string : stringList) {
            String[] arr = string.split(",");
            customerList.add(new Customer(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5],
                    arr[6], arr[7], arr[8]));
        }
        return customerList;
    }
}
