package controller;

import model.entity.Vehicle;
import model.service.VehicleService;
import view.InputDisplay;
import view.VehicleView;

import java.util.Scanner;

public class VehicleController {
    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        final int ADD = 1;
        final int DISPLAY = 2;
        final int DELETE = 3;
        final int FIND = 4;
        final int EXIT = 5;
        while (true) {
            System.out.println("------MENU------");
            System.out.println("""
                    1.Thêm
                    2.Hiển thị
                    3.Xóa
                    4.Tìm
                    5.Thoát
                    Vui lòng chọn chức năng""");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case ADD -> {
                    VehicleService.repo.add(InputDisplay.inputChoice());
                }
                case DISPLAY -> VehicleView.displayMenu();
                case DELETE -> VehicleView.delete();
                case FIND -> VehicleView.find();
                case EXIT -> {
                    return;
                }
            }

        }

    }

}
