package repository;

import entity.Employee;
import utils.Helper;
import utils.Library;
import utils.ReadAndWriteFile;
import view.PersonView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String EMPLOYEE_LIST = "src/data/employee.csv";

    @Override
    public void handleAdd() {
        Employee temp = PersonView.inputEmployee();
        List<String> stringList = new ArrayList<>();
        stringList.add(temp.toCSV());
        ReadAndWriteFile.write(EMPLOYEE_LIST, stringList, true);
    }

    @Override
    public void handleDisplay() {
        for (Employee employee : getAll()) {
            System.out.println(employee);
        }
    }

    @Override
    public void handleEdit() {
        String temp= Helper.inputString("Nhập tên muốn tìm");
        List<Employee> employeeList=getAll();
        for (Employee employee : employeeList) {
            if (Objects.equals(employee.getName(), temp)){
                double salary=Helper.inputDouble("Nhập lương muốn thay đổi",0);
                employee.setWage(salary);
            }
        }
    }

    @Override
    public List<Employee> getAll() {
        return Library.getAll(
                EMPLOYEE_LIST,
                arr->new Employee(arr[0],arr[1],arr[2],arr[3],arr[4],
                        arr[5],arr[6],arr[7],arr[8],Double.parseDouble(arr[9]))
        );
    }
}
