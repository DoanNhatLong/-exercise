package controller;

import model.repository.EmployeeRepository;
import model.service.EmployeeService;
import view.InputData;

import java.util.Scanner;

public class EmployeeController {
    public final static Scanner sc=new Scanner(System.in);
    public static void showMenu(){
        final int ADD=1;
        final int DISPLAY=2;
        final int DELETE=3;
        final int FIND=4;
        final int PAGE=5;
        final int EDIT=6;
        final int FILLED=7;
        final int CALCULATE=8;
        final int EXIT=9;
        while (true){
            System.out.println("------MENU------");
            System.out.println("""
                    1. Thêm
                    2. Hiển thị
                    3. Xóa
                    4. Tìm
                    5. Hiển thị theo list 3
                    6. Chỉnh sửa
                    7. Lọc
                    8. Tính toán
                    9. Thoát chương trình""");
            System.out.println("-------Nhập vào để lựa chọn ------");
            int choice=Integer.parseInt(sc.nextLine());
            switch (choice){
                case ADD -> {
                    EmployeeService.repo.addEmployee(InputData.inputEmployee());
                }
                case DISPLAY -> {
                    EmployeeService.repo.displayEmployees(InputData.inputChoice());
                }
                case DELETE -> {
                    System.out.println("Nhập ID cần xóa");
                    String id=sc.nextLine();
                    EmployeeService.deleteEmployee(id);
                }
                case FIND -> {
                    System.out.println("Nhập id cần tìm");
                    String id=sc.nextLine();
                    EmployeeService.findByID(id);

                }
                case PAGE -> {

                }
                case EDIT -> {

                }
                case CALCULATE -> {

                }
                case FILLED -> {

                }
                case EXIT-> {
                    return;
                }

            }
        }

    }
}
