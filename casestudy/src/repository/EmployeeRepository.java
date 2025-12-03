package repository;

import entity.Employee;
import ultity.Helper;
import ultity.Library;
import ultity.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class EmployeeRepository implements IEmployeeRepository {
    final static String EMPLOYEE_LIST = "src/data/employee.csv";

    @Override
    public void display() {
        List<Employee> employeeList= getAll();
        Helper.display(employeeList);
        //        Library.printListPaginated(employeeList,3);
    }

    @Override
    public void addPerson(Employee temp) {
        List<String> stringList = new ArrayList<>();
        stringList.add(temp.toCSV());
        ReadAndWriteFile.write(EMPLOYEE_LIST, stringList, true);
    }

    @Override
    public void edit(String id, Employee temp) {
        boolean flag=false;
        List<Employee> employeeList= getAll();
        for (int i = 0; i < employeeList.size(); i++) {
            if (Objects.equals(employeeList.get(i).getIdEmployee(), id)) {
                employeeList.set(i, temp);
                flag=true;
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Employee employee : employeeList) {
            stringList.add(employee.toCSV());
        }
        ReadAndWriteFile.write(EMPLOYEE_LIST,stringList,false);
        System.out.println(flag?"Đã sửa thành công":"Không có id trùng");
    }

    @Override
    public List<Employee> getAll() {
        List<String> stringList = ReadAndWriteFile.readFileCSVToStringList(EMPLOYEE_LIST);
        List<Employee> employeeList = new ArrayList<>();
        for (String string : stringList) {
            String[] arr = string.split(",");
            employeeList.add(new Employee(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5],
                    arr[6], arr[7], arr[8], Double.parseDouble(arr[9])));
        }
        return employeeList;
    }
}
