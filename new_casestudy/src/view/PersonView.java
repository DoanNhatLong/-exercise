package view;

import entity.Customer;
import entity.Employee;
import repository.AllListToInput;
import utils.Helper;
import utils.Library;
import utils.UserException;

public class PersonView {
    public static Employee inputEmployee() {
        String name = inputName();
        String date = inputDate();
        String gender = Library.readOptionByIndex(AllListToInput.gender, "Chọn giới tính");
        String idPerson = inputIdPerson();
        String tel = inputPhone();
        String email = Helper.inputString("Nhập email");
        String idEmployee = inputIdEmployee();
        String level = Library.readOptionByIndex(AllListToInput.level, "Chọn trình độ");
        String position = Library.readOptionByIndex(AllListToInput.position, "Chọn vị trí");
        double salary = inputSalary();
        return new Employee(name, date, gender, idPerson, tel, email, idEmployee, level, position, salary);
    }

    public static Customer inputCustomer() {
        String name = inputName();
        String date = inputDate();
        String gender = Library.readOptionByIndex(AllListToInput.gender, "Chọn giới tính");
        String idPerson = inputIdPerson();
        String tel = inputPhone();
        String email = Helper.inputString("Nhập email");
        String idEmployee = inputIdCustomer();
        String type = Library.readOptionByIndex(AllListToInput.typeCustomer, "Chọn loại khách hàng");
        String address = Helper.inputString("Nhập địa chỉ");
        return new Customer(name, date, gender, idPerson, tel, email, idEmployee, type, address);
    }

    private static String inputIdCustomer() {
        while (true) {
            try {
                String temp = Helper.inputString("Nhập ID khách hàng ( KH-XXXX)");
                UserException.validateCustomerCode(temp);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static String inputIdEmployee() {
        return Library.inputData(
                () -> Helper.inputString("Nhập ID nhân viên ( NV-XXXX)"),
                UserException::validateEmployeeCode
        );
    }

    public static String inputName() {
        return Library.inputData(
                () -> Helper.inputString("Nhập tên ( in hoa chữ đầu )"),
                UserException::validateName
        );
    }

    public static String inputDate() {
        return Library.inputData(
                ()->Helper.inputString("Nhập ngày (dd/mm/yyyy"),
                (String temp)->UserException.validateDate(temp,18,120)
        );
    }

    public static String inputIdPerson() {
        return Library.inputData(
                ()->Helper.inputString("Nhập căn cước ( 9 hoặc 12 số)"),
                UserException::validateIdPerson
        );
    }

    public static String inputPhone() {
        return Library.inputData(
                ()->Helper.inputString("Nhập số điện thoại (10 số bắt đầu bằng 0)"),
                UserException::validatePhone
        );
    }

    public static double inputSalary() {
        return Library.inputData(
                ()->Helper.inputDouble("Nhập lương"),
                UserException::validateSalary
        );
    }

}
