package repository;

import entity.*;
import ultity.Library;
import ultity.ReadAndWriteFile;
import view.VehicleView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class VehicleRepository implements IVehicleRepository {
    static final String VEHICLE_LIST = "src/data/vehicle.csv";

    @Override
    public void handleDisplay() {
        for (Vehicle vehicle : getAll()) {
            System.out.println(vehicle);
        }
    }

    @Override
    public void handleAdd(Vehicle temp) {
        List<String> stringList = new ArrayList<>();
        stringList.add(temp.toCSV());
        ReadAndWriteFile.write(VEHICLE_LIST, stringList, true);
    }

    @Override
    public void handleFilter(String id) {
        List<Vehicle> vehicleList = Library.findByString(
                getAll(), id, vehicle -> String.valueOf(vehicle.getIdCar() == id));
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle);
            break;
        }
        if (!vehicleList.isEmpty()) {
            System.out.println("Kết quả tìm tiếm");
        } else System.out.println("Không có id trùng");
    }

    @Override
    public void handleDelete(String id) {
        boolean removed = Library.handleDelete(
                getAll()
                , vehicle -> Objects.equals(vehicle.getIdCar(), id)
                , Vehicle::toCSV
                , VEHICLE_LIST
        );
        System.out.println(removed ? "Đã xóa thành công" : "Không có id phù hợp");
    }

    @Override
    public List<Vehicle> getAll() {
        List<String> stringList = ReadAndWriteFile.readFileCSVToStringList(VEHICLE_LIST);
        List<Vehicle> vehicleList = new ArrayList<>();
        for (String string : stringList) {
            String[] arr = string.split(",");
            switch (arr[0]) {
                case "Truck" -> {
                    String id = arr[1];
                    Company company = VehicleView.parseCompany(arr[2]);
                    int year = Integer.parseInt(arr[3]);
                    String owner = arr[4];
                    double load = Double.parseDouble(arr[5]);
                    vehicleList.add(new Truck(id, company, year, owner, load));
                }
                case "Oto" -> {
                    String id = arr[1];
                    Company company = VehicleView.parseCompany(arr[2]);
                    int year = Integer.parseInt(arr[3]);
                    String owner = arr[4];
                    int seat = Integer.parseInt((arr[5]));
                    String style = arr[6];
                    vehicleList.add(new Oto(id, company, year, owner, seat, style));
                }
                case "Motor" -> {
                    String id = arr[1];
                    Company company = VehicleView.parseCompany(arr[2]);
                    int year = Integer.parseInt(arr[3]);
                    String owner = arr[4];
                    double power = Double.parseDouble((arr[5]));
                    vehicleList.add(new Motor(id, company, year, owner, power));
                }
            }
        }
        return vehicleList;
    }
}
