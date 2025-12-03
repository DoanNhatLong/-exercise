package controller;

import service.IPromotionService;
import service.PromotionService;

import java.util.Scanner;

public class PromotionManagement {

    static final IPromotionService promotionService = new PromotionService();
    static final int CUSTOMER_USE_SERVICE = 1;
    static final int CUSTOMER_GET_VOUCHER = 2;
    static final int RETURN = 3;

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("------MENU------");
                System.out.println("""
                        1. Customer use service
                        2. Customer get voucher
                        3. Return""");
                System.out.println("-------Nhập vào để lựa chọn ------");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case CUSTOMER_USE_SERVICE -> {
                        promotionService.displayUseService();
                    }
                    case CUSTOMER_GET_VOUCHER -> {
                        promotionService.displayGetVoucher();
                    }
                    case RETURN -> {
                        return;
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
