package controller;

import java.util.Scanner;

public class ManagerController {
    public static Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        final int PACK = 1;
        final int PLAYER = 2;
        final int FINANCE = 3;
        final int SQUAD = 4;
        final int MATCH = 5;
        final int MISSION = 6;
        final int BUY_COIN = 7;
        final int EXIT = 8;
        while (true) {
            try {
                System.out.println("------MENU------");
                System.out.println("""
                        1. Bóc pack
                        2. Cầu thủ
                        3. Tài chính
                        4. Đội hình
                        5. Trận đấu
                        6. Nhiệm vụ
                        7. Mua coin
                        8. Thoát chương trình""");
                System.out.println("-------Nhập vào để lựa chọn ------");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case PACK -> PackController.showMenu();
                    case PLAYER -> PlayerController.showMenu();
                    case FINANCE -> {

                    }
                    case SQUAD -> {

                    }
                    case MATCH -> {

                    }
                    case MISSION -> {

                    }
                    case BUY_COIN -> {

                    }
                    case EXIT -> {
                        return;
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
