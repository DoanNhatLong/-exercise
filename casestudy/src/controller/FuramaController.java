package controller;

import java.util.Scanner;

public class FuramaController {
    public static final Scanner sc = new Scanner(System.in);

    public static void displayMainMenu() {

        while (true) {
            try {
                System.out.println("------MENU------");
                System.out.println("""
                        1. Employee Management
                        2. Customer Management
                        3. Facility Management
                        4. Booking Management
                        5. Promotion Management
                        6. Exit""");
                System.out.println("-------Nhập vào để lựa chọn ------");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> EmployeeManagement.showMenu();
                    case 2 -> CustomerManagement.showMenu();
                    case 3 -> FacilityManagement.showMenu();
                    case 4 -> BookingManagement.showMenu();
                    case 5 -> PromotionManagement.showMenu();
                    case 6 -> {
                        return;
                    }
                    default -> System.out.println("Nhập sai yêu cầu, vui lòng nhập lại");
                }
            } catch (Exception e) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại");
            }
        }
    }
}
