package controller;

import service.BankService;
import service.IBankService;

import java.util.Scanner;

public class BankController {
    public static void showMenu() {
        IBankService bankService = new BankService();
        final int ADD = 1;
        final int DISPLAY = 2;
        final int FIND_BY_TYPE = 3;
        final int FIND_BY_DATE = 4;
        final int UPDATED = 5;
        final int SORT = 6;
        final int EXIT = 7;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("------Quản lý ngân hàng----");
            System.out.println("Chọn chức năng");
            System.out.println("""
                    1. Thêm
                    2. Hiển thị
                    3. Tìm theo loại tài khoản
                    4. Tìm theo ngày
                    5. Cập nhập
                    6. Sắp xếp
                    7. Thoát""");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case ADD -> bankService.handleAdd();
                case DISPLAY -> bankService.handleDisplay();
                case FIND_BY_TYPE -> bankService.handleFindByType();
                case FIND_BY_DATE -> bankService.handleFindByDate();
                case UPDATED -> bankService.handleUpdated();
                case SORT -> bankService.handleSort();
                case EXIT -> {
                    return;
                }
            }
        }
    }


}
