package controller;

import entity.Drug;
import sercive.DrugService;
import sercive.IDrugService;
import ultity.Helper;
import view.DrugView;

import java.text.ParseException;
import java.util.Scanner;

public class DrugController {
    public static void showMenu() throws ParseException {
        IDrugService drugService = new DrugService();
        final int ADD = 1;
        final int DISPLAY = 2;
        final int UPDATED = 3;
        final int DELETE = 4;
        final int SORT = 5;
        final int EXIT = 6;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("------Quản lý hiệu thuốc----");
            System.out.println("Chọn chức năng");
            System.out.println("""
                    1. Thêm
                    2. Hiển thị
                    3. Cập nhập
                    4. Xóa
                    5. Sắp xếp
                    6. Thoát""");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case ADD -> {
                    Drug temp= DrugView.inputDrug();
                    drugService.addDrug(temp);
                }
                case DISPLAY -> drugService.displayDrug();

                case UPDATED -> {
                    String name= Helper.inputString("Nhập tên muốn cập nhập");
                    drugService.updatedDrug(name);
                }
                case DELETE -> drugService.deleteDrug();

                case SORT -> drugService.sortDrug();

                case EXIT -> {
                    return;
                }
            }


        }
    }
}