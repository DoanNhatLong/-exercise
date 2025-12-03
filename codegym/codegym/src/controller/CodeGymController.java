package controller;

import java.util.Scanner;

public class CodeGymController {
    public final static Scanner sc = new Scanner(System.in);
    public static Integer choiceFirst;
    public static void showMenu() {
        while (true) {
            System.out.println("------MENU------");
            System.out.println("""
                    1. Quản lí sinh viên
                    2. Quản lí giáo viên
                    3. Quản lí giáo vụ
                    4. Thoát chương trình""");
            System.out.println("-------Nhập vào để lựa chọn ------");
            choiceFirst = Integer.parseInt(sc.nextLine());
            switch (choiceFirst) {
                case 1 -> StudentController.showMenu();
                case 2 -> TrainerController.showMenu();
                case 3 -> MinistryController.showMenu();
                case 4 -> {
                    return;
                }
            }
        }
    }

}
