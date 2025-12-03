package view;

import model.entity.*;
import model.repository.CompanyRepository;

import java.util.Scanner;

public class InputDisplay {
    public static Vehicle inputChoice() {
        Scanner sc = new Scanner(System.in);
        Vehicle input;
        while (true) {
            System.out.println("------MENU------");
            System.out.println("""
                    1.Xe Motor
                    2.Xe tải
                    3.Xe Oto
                    4.Về menu chính
                    Vui lòng chọn chức năng""");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    Vehicle temp = InputFirst.inputFirst();
                    System.out.println("Nhập công suât");
                    double power = Double.parseDouble(sc.nextLine());
                    input = new Motor(temp, power);
                    return input;

                }
                case 2 -> {
                    Vehicle temp = InputFirst.inputFirst();
                    System.out.println("Nhập tải trọng");
                    double load = Double.parseDouble(sc.nextLine());
                    input = new Truck(temp, load);
                    return input;
                }

                case 3 -> {
                    Vehicle temp = InputFirst.inputFirst();
                    System.out.println("Nhập chỗ");
                    int seat = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập kiểu");
                    String style = sc.nextLine();
                    input = new Oto(temp, style, seat);
                    return input;
                }
                case 4 -> {
                    return null;
                }
            }

        }
    }

}
