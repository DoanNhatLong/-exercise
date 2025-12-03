package view;

import model.entity.Vehicle;
import model.repository.VehicleRepository;
import model.service.VehicleService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class VehicleView {
    public static void displayMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("------MENU------");
            System.out.println("""
                    1.Xe motor
                    2.Xe tải
                    3.Xe oto
                    4.Về menu chính
                    Vui lòng chọn chức năng""");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> System.out.println(VehicleService.repo.getAll().get(0));
                case 2 -> System.out.println(VehicleService.repo.getAll().get(1));
                case 3 -> System.out.println(VehicleService.repo.getAll().get(2));
                case 4 -> {
                    return;
                }
            }

        }
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID muốn xóa");
        boolean flag = true;
        String id = sc.nextLine();
        for (List<? extends Vehicle> vehicles : VehicleService.repo.getAll()) {
            for (Vehicle item : vehicles) {
                if (Objects.equals(item.getCarID(), id)) {
                    System.out.println("Bạn có muốn xóa" + item + "không ?");
                    System.out.println("""
                            Yes
                            No""");
                    String confim = sc.nextLine();
                    if (Objects.equals(confim, "Yes")) {
                        vehicles.remove(item);
                        System.out.println("Đã xóa thành công");
                        flag = false;
                        break;
                    } else return;
                }
            }
            if (flag) {
                System.out.println(" Không tìm thấy ID");
            }
        }
    }

    public static void find() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID muốn tìm ");
        String id = sc.nextLine();
        for (List<? extends Vehicle> vehicles : VehicleService.repo.getAll()) {
             vehicles.stream()
                    .filter(vehicle -> vehicle.getCarID().contains(id))
                    .forEach(System.out::println);
        }
    }
}
