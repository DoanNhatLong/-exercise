package view;

import entity.Motor;
import entity.Oto;
import entity.Truck;
import entity.Vehicle;
import ultity.Helper;

import static ultity.Helper.*;
import static view.RunApp.sc;

public class VehicleView {
    public static Vehicle inputVehicle() {
        int type = chooseType();
        String idCar = inputString("Nhập biển kiếm soát");
        String company = inputString("Nhập hãng xe");
        String name = inputString("Nhập tên xe");
        String owner = inputString("Nhập chủ sỡ hữu");
        switch (type) {
            case 1 -> {
                int load = inputInt("Nhập tải trọng", 0);
                return new Truck(idCar, company, name, owner, load);
            }
            case 2 -> {
                int seat = inputInt("Nhập tải trọng", 0);
                String style = inputString("Nhâ vào kiểu xe");
                return new Oto(idCar, company, name, owner, seat, style);
            }
            case 3 -> {
                double power = inputDouble("Nhập công suất", 0);
                return new Motor(idCar, company, name, owner, power);
            }
        }
        return null;
    }

    public static int chooseType() {
        while (true) {
            System.out.println("------MENU------");
            System.out.println("""
                    1. Xe tải
                    2. Xe oto
                    3. Xe máy
                    """);
            System.out.println("-------Nhập vào để lựa chọn ------");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 1 || choice == 2 || choice == 3) {
                return choice;
            } else {
                System.out.println("Nhập số từ 1-3");
            }
        }

    }
}
