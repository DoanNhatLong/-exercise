package view;

import entity.Car;
import entity.Drone;
import entity.Vehicle;
import utils.Helper;
import utils.Library;
import utils.ReadAndWriteFile;
import utils.UserException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static view.RunApp.ERROR_INPUT;
import static view.RunApp.sc;

public class VehicleView {
    static final String COMPANY_LIST = "src/data/company.csv";

    public static Vehicle inputVehicle() {
        int type = chooseType();
        if (type == 1) {
            String idVehicle = inputIdDrone();
            String nameCompany = inputCompany();
            int year = Helper.inputInt("Nhập năm sản xuất", 0, LocalDate.now().getYear());
            String human = Helper.inputString("Nhập người điều phối");
            int fly = Helper.inputInt("Nhập tầm bay", 0);
            return new Drone(idVehicle, nameCompany, year, human, fly);
        }
        if (type == 2) {
            String idVehicle = inputIdCar();
            String nameCompany = inputCompany();
            int year = Helper.inputInt("Nhập năm sản xuất", 0, LocalDate.now().getYear());
            String human = Helper.inputString("Nhập người điều phối");
            String protect = "Cấp độ " + Helper.inputInt("Cấp độ của xe là ( nhập số): ", 1, 10);
            return new Car(idVehicle, nameCompany, year, human, protect);
        }
        return null;
    }

    public static int chooseType() {
        while (true) {
            try {
                System.out.println("------MENU------");
                System.out.println("""
                        1. Add Drone
                        2. Add Car""");
                System.out.println("-------Nhập vào để lựa chọn ------");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    System.out.println("Nhập số hợp lệ");
                }
            } catch (NumberFormatException e) {
                System.out.println(ERROR_INPUT);
            }
        }
    }

    public static int chooseFilter(){
        while (true) {
            try {
                System.out.println("------MENU------");
                System.out.println("""
                        1. Tìm kiếm theo số hiệu
                        2. Tìm kiếm theo tên người """);
                System.out.println("-------Nhập vào để lựa chọn ------");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    System.out.println("Nhập số hợp lệ");
                }
            } catch (NumberFormatException e) {
                System.out.println(ERROR_INPUT);
            }
        }
    }

    public static int chooseTypeDisplay() {
        while (true) {
            try {
                System.out.println("------MENU------");
                System.out.println("""
                        1. Display Drone
                        2. Display Car""");
                System.out.println("-------Nhập vào để lựa chọn ------");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice == 1 || choice == 2) {
                    return choice;
                }else {
                    System.out.println("Nhập số hợp lệ");
                }
            } catch (NumberFormatException e) {
                System.out.println(ERROR_INPUT);
            }
        }
    }

    public static String inputIdDrone() {
        return Library.inputData(
                () -> Helper.inputString("Nhập mã (DRN-YYY)"),
                UserException::validateDrone
        );
    }

    public static String inputCompany() {
        List<String> stringList = ReadAndWriteFile.readFileCSVToStringList(COMPANY_LIST);
        List<String> nameCompany = new ArrayList<>();
        for (String string : stringList) {
            String[] arr = string.split(",");
            nameCompany.add(arr[1]);
        }
        return Library.readOptionByIndex(nameCompany, "Chọn tên công ty");

    }

    public static String inputIdCar() {
        return Library.inputData(
                () -> Helper.inputString("Nhập mã (XTT-YYY)"),
                UserException::validateCar
        );
    }

}
