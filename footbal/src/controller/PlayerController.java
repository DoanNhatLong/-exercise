package controller;

import static controller.ManagerController.sc;

public class PlayerController {
    public static void showMenu() {
        while (true) {
            System.out.println("------MENU------");
            System.out.println("""
                    1. Hiển thị
                    2. Sa thải
                    3. Sắp xếp theo vị trí
                    4. Sắp xếp theo luơng
                    5. Thoát chương trình""");
            System.out.println("-------Nhập vào để lựa chọn ------");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> {
                    return;
                }
            }
        }
    }
}
