package view;

import entity.*;
import repository.AllListToInput;
import repository.CustomerRepository;
import ultity.Helper;
import ultity.Library;

import java.util.Date;


import static controller.FuramaController.sc;


public class FuramaView {
    public static Employee inputEmployee() {
        String name = inputName();
        String date=inputDate();
        String gender = Helper.inputString("Nhập giới tính");
        String idPerson=inputIdPerson();
        String tel = inputTel();
        String email = Helper.inputString("Nhập email");
        String idEmployee=inputIdEmployee();
        String level = Library.readOptionByIndex(AllListToInput.level);
        String position = Library.readOptionByIndex(AllListToInput.position);
        double wage = inputWage();
        return new Employee(name, date, gender, idPerson , tel, email, idEmployee, level, position, wage);
    }


    public static Customer inputCustomer() {
        String name = inputName();
        String date=inputDate();
        String gender = Library.readOptionByIndex(AllListToInput.gender);
        String idPerson=inputIdPerson();
        String tel = inputTel();
        String email = Helper.inputString("Nhập email");
        String idCustomer=inputIdCustomer();
        String typeCustomer = Library.readOptionByIndex(AllListToInput.typeCustomer);
        String address = Helper.inputString("Nhập địa chỉ");
        return new Customer(name, date, gender, idPerson, tel, email, idCustomer, typeCustomer, address);
    }

    public static Facility inputFacility() throws UserException {
        while (true) {
            System.out.println("-----Nhập lựa chọn-----");
            System.out.println("""
                    1.Add New Villa
                    2.Add New House
                    3.Add New Room
                    4.Back to Menu""");
            System.out.println("Nhập lựa chọn");
            int type = Integer.parseInt(sc.nextLine());
            if (type == 1 | type == 2 | type == 3) {
                String name=inputName();
                Double area = Helper.inputDouble("Nhập diện tích (>30) ",30,Double.POSITIVE_INFINITY);
                Double price = Helper.inputDouble("Nhập giá");
                String style = Helper.inputString("Nhập kiểu");
                int number = Helper.inputInt("Nhập số người",0,20);
                switch (type) {
                    case 1 -> {
                        String prefix="SVVL";
                        String id= inputIdFacility(prefix);
                        System.out.println("Nhập Tiêu chuẩn phòng");
                        String room = sc.nextLine();
                        double pool = Helper.inputDouble("Nhập diện tích hồ bơi (>30m2)",30,Double.POSITIVE_INFINITY);
                        int floor = Helper.inputInt("Nhập tầng",1, (int) Double.POSITIVE_INFINITY);
                        return new Villa(id, name, area, price, style, number, room, pool, floor);
                    }
                    case 2 -> {
                        String prefix="SVHO";
                        String id= inputIdFacility(prefix);
                        System.out.println("Nhập Tiêu chuẩn phòng");
                        String room = sc.nextLine();
                        int floor = Helper.inputInt("Nhập tầng",1, (int) Double.POSITIVE_INFINITY);
                        return new House(id, name, area, price, style, number, room, floor);
                    }
                    case 3 -> {
                        String prefix="SVRO";
                        String id= inputIdFacility(prefix);
                        String room = Helper.inputString("Nhập phòng");
                        return new Room(id, name, area, price, style, number, room);
                    }
                }
            } else if (type == 4) {
                return null;
            }
        }
    }

    public static Booking inputBooking() {
        System.out.println("Nhập ID Service ");
        String id = sc.nextLine();
        String idBooking =Library.readOptionByIndex(AllListToInput.idBooking);
        System.out.println("Nhập ngày booking");
        Date date = Library.inputDate();
        System.out.println("Nhập ngày bắt đầu");
        Date start = Library.inputDate();
        System.out.println("Nhập ngày kết thúc");
        Date end = Library.inputFutureDate();
        String temp=chooseCustomer().getIdCustomer();
        return new Booking(id, idBooking, date, start, end, temp);
    }

    public static String inputName(){
        while (true) {
            try {
                String name = Helper.inputString("Nhập tên");
                UserException.validateName(name);
                return name;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String inputDate(){
        while (true) {
            try {
                String temp = Helper.inputString("Nhập ngày sinh");
                UserException.validateBirthDate(temp);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static String  inputIdEmployee(){
        while (true) {
            try {
                String temp = Helper.inputString("Nhập ID nhân viên");
                UserException.validateEmployeeCode(temp);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String  inputIdPerson(){
        while (true) {
            try {
                String temp = Helper.inputString("Nhập IDPerson");
                UserException.validateIdPerson(temp);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static String  inputIdCustomer(){
        while (true) {
            try {
                String temp = Helper.inputString("Nhập ID khách hàng");
                UserException.validateCustomerCode(temp);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Customer chooseCustomer() {
        CustomerRepository customerRepository=new CustomerRepository();
        var list= customerRepository.getAll();
        while (true) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
            System.out.print("Nhập lựa chọn: ");
            String input = sc.nextLine().trim();
            if (input.matches("\\d")) {
                int index = Integer.parseInt(input);
                if (index >= 1 && index <= list.size()) {
                    return list.get(index - 1);
                }
            }
        }
    }

    public static String inputTel(){
        while (true) {
            try {
                String temp = Helper.inputString("Nhập số điện thoại");
                UserException.validatePhone(temp);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static double inputWage(){
        while (true) {
            try {
                double temp = Helper.inputDouble("Nhập lương");
                UserException.validateSalary(temp);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String inputIdFacility(String prefix){
        while (true) {
            try {
                String temp = Helper.inputString("Nhập ID  ." + prefix + "-YYYY");
                UserException.validateFacilityCode(temp, prefix);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }






}



