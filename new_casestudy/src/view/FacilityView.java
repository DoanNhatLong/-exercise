package view;

import entity.Facility;
import entity.House;
import entity.Room;
import entity.Villa;
import utils.Helper;
import utils.Library;
import utils.Return;
import utils.UserException;

import static view.RunApp.*;

public class FacilityView {
    public static Facility inputFacility() {
        while (true) {
            try {
                System.out.println("------MENU------");
                System.out.println("""
                        1. Add House
                        2. Add Villa
                        3. Add Room
                        4. Return""");
                System.out.println("-------Nhập vào để lựa chọn ------");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> {
                        return inputHouse();
                    }
                    case 2 -> {
                        return inputVilla();
                    }
                    case 3 -> {
                        return inputRoom();
                    }
                    case 4 -> throw new Return("Trở về menu");
                    default -> System.out.println(ERROR_NUMBER);

                }
            } catch (NumberFormatException e) {
                System.out.println(ERROR_INPUT);
            } catch (Return e) {
                return null;
            }
        }

    }

    private static Villa inputVilla() {
        String idService = inputIdServiceVilla();
        String name = inputNameService();
        double area = Helper.inputDouble("Dieenj tích hồ bơi (m2)", 30);
        double price = Helper.inputDouble("Nhập giá");
        String style = Helper.inputString("Nhập kiểu ");
        int number = inputNumberPeoPle();
        String standard = Helper.inputString("Nhập tiêu chuẩn");
        double areaPool = Helper.inputDouble("Nhập diện tích", 0);
        int floor = Helper.inputInt("Nhập tầng", 0);
        return new Villa(idService, name, area, price, style, number, standard, areaPool, floor);
    }

    private static Room inputRoom() {
        String idService = inputIdServiceRoom();
        String name = inputNameService();
        double area = Helper.inputDouble("Dieenj tích hồ bơi (m2)", 30);
        double price = Helper.inputDouble("Nhập giá");
        String style = Helper.inputString("Nhập kiểu ");
        int number = inputNumberPeoPle();
        String free = Helper.inputString("Nhập dịch vụ miễn phí");
        return new Room(idService, name, area, price, style, number, free);
    }

    private static House inputHouse() {
        String idService = inputIdServiceHouse();
        String name = inputNameService();
        double area = Helper.inputDouble("Dieenj tích hồ bơi (m2)", 30);
        double price = Helper.inputDouble("Nhập giá");
        String style = Helper.inputString("Nhập kiểu ");
        int number = inputNumberPeoPle();
        String standard = Helper.inputString("Nhập tiêu chuẩn");
        int floor = Helper.inputInt("Nhập tầng", 0);
        return new House(idService, name, area, price, style, number, standard, floor);

    }

    private static String inputIdServiceVilla() {
        return Library.inputData(
                () -> Helper.inputString("Nhập mã dịch vụ ( SVVL-XXXX"),
                UserException::validateVilla
        );
    }

    private static String inputIdServiceHouse() {
        return Library.inputData(
                () -> Helper.inputString("Nhập mã dịch vụ ( SVHO-XXXX"),
                UserException::validateHouse
        );
    }

    private static String inputIdServiceRoom() {
        return Library.inputData(
                () -> Helper.inputString("Nhập mã dịch vụ ( SVRO-XXXX"),
                UserException::validateRoom
        );
    }

    private static String inputNameService() {
        return Library.inputData(
                () -> Helper.inputString("Nhập tên dịch vụ"),
                UserException::validateNameService
        );
    }

    private static int inputNumberPeoPle() {
        return Library.inputData(
                () -> Helper.inputInt("Nhập vào số người"),
                UserException::validateNumberPeople

        );
    }


}
