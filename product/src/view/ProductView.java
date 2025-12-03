package view;

import entity.Electric;
import entity.Food;
import entity.Product;
import ultity.Helper;
import ultity.UserException;

import static view.RunApp.*;

public class ProductView {
    public static Product inputProduct() {
        int type = inputType();
        String idProduct = Helper.inputString("Nhập mã sản phẩm ");
        String name = Helper.inputString("Nhập tên sản phẩm ");
        int quantity = Helper.inputInt("Nhập lượng hàng", 0);
        String date = inputDate();
        switch (type) {
            case 1 -> {
                String expired = inputFutureDate();
                return new Food(idProduct, name, quantity, date, expired);
            }
            case 2 -> {
                int battery = Helper.inputInt("Nhập dung lượng pin", 0);
                return new Electric(idProduct, name, quantity, date, battery);
            }
            case 3 -> {
                String material = Helper.inputString("Nhập vật liệu");
                return new Food(idProduct, name, quantity, date, material);
            }
        }
        return null;
    }

    public static String inputDate(){
        while (true) {
            try {
                String temp = Helper.inputString("Nhập ngày sinh");
                UserException.validateDate(temp,0,150);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static String inputFutureDate(){
        while (true) {
            try {
                String temp = Helper.inputString("Nhập ngày hết hạn");
                UserException.validateFutureDate(temp);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static int inputType() {
        int choice;
        while (true) {
            System.out.println("------MENU------");
            System.out.println("""
                    1. Thực phẩm
                    2. Hàng điện tử
                    3. Đồ gia dụng
                    """);
            System.out.print("Nhập vào để lựa chọn: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(ERROR_INPUT);
                continue;
            }
            if (choice == 1 || choice == 2 || choice == 3) {
                return choice;
            } else {
                System.out.println(ERROR_NUMBER);
            }
        }
    }


}
