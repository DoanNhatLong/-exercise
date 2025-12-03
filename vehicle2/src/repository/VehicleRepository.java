package repository;

import entity.Motor;
import entity.Oto;
import entity.Truck;
import entity.Vehicle;
import ultity.Library;
import ultity.ReadAndWriteFile;
import view.VehicleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static ultity.Helper.inputInt;
import static ultity.Helper.inputString;

public class VehicleRepository implements IVehicleRepository {
    public static final String VEHICLE_LIST = "src/data/Vehicle.csv";


    @Override
    public void handleDisplay() {
        int temp = VehicleView.chooseType();
        switch (temp) {
            case 1 -> {
                for (Vehicle vehicle : getAll()) {
                    if (vehicle instanceof Truck) {
                        System.out.println(vehicle);
                    }
                }
            }
            case 2 -> {
                for (Vehicle vehicle : getAll()) {
                    if (vehicle instanceof Oto) {
                        System.out.println(vehicle);
                    }
                }
            }
            case 3 -> {
                for (Vehicle vehicle : getAll()) {
                    if (vehicle instanceof Motor) {
                        System.out.println(vehicle);
                    }
                }
            }
        }
    }

    @Override
    public void handleAdd() {
        Vehicle temp = VehicleView.inputVehicle();
        List<String> stringList = new ArrayList<>();
        assert temp != null;
        stringList.add(temp.toCSV());
        ReadAndWriteFile.write(VEHICLE_LIST, stringList, true);

    }

    @Override
    public void handleFilter() {
        String temp = inputString("Nhập tên muốn tìm");
        boolean flag = false;
        for (Vehicle vehicle : getAll()) {
            if (vehicle.getName().contains(temp)) {
                System.out.println(vehicle);
                flag = true;
            }
        }
        System.out.println(flag ? "Kết quả tìm kiếm:" : "Không có tên trùng");
    }

    @Override
    public void handleDelete() {
        String temp = inputString("Nhập vào biển kiểm soaát muốn xóa");
        List<String> stringList = new ArrayList<>();
        List<Vehicle> vehicleList = getAll();
        boolean flag=false;
        for (Vehicle vehicle : vehicleList) {
            if (Objects.equals(vehicle.getIdCar(), temp)) {
                int choice = inputInt("""
                        Bạn có muốn xóa không
                         1. Yes
                         2. No""", 1, 2);
                if (choice == 1) {
                    vehicleList.remove(vehicle);
                    for (Vehicle vehicle1 : vehicleList) {
                        if (vehicle1 instanceof Truck t) {
                            stringList.add(t.toCSV());
                        } else if (vehicle1 instanceof Oto o) {
                            stringList.add(o.toCSV());
                        } else if (vehicle1 instanceof Motor m) {
                            stringList.add(m.toCSV());
                        }
                    }
                } else return;
                ReadAndWriteFile.write(VEHICLE_LIST,stringList,false);
                flag=true;
                break;
            }


        }
        System.out.println(flag?"Đã xóa thành công":"Khoogn tìm thấy biển trùng");
    }

    @Override
    public List<Vehicle> getAll() {
        return Library.getAll(
                VEHICLE_LIST,
                Map.of(
                        "Truck", arr -> new Truck(arr[1], arr[2], arr[3], arr[4], Integer.parseInt(arr[5])),
                        "Oto", arr -> new Oto(arr[1], arr[2], arr[3], arr[4], Integer.parseInt(arr[5]), arr[6]),
                        "Motor", arr -> new Motor(arr[1], arr[2], arr[3], arr[4], Double.parseDouble(arr[5]))
                )

        );
    }
}
