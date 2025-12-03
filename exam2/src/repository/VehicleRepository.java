package repository;

import entity.Car;
import entity.Drone;
import entity.Vehicle;
import utils.Library;
import utils.NotFoundVehicleException;
import utils.ReadAndWriteFile;
import view.VehicleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static utils.Helper.inputString;

public class VehicleRepository implements IVehicleRepository {
    static final String DRONE_LIST = "src/data/drone.csv";
    static final String CAR_LIST = "src/data/car.csv";
    static List<Vehicle> vehicleList = new ArrayList<>();

    @Override
    public void handleAdd() {
        Vehicle temp = VehicleView.inputVehicle();
        List<String> stringList = new ArrayList<>();
        if (temp instanceof Drone) {
            stringList.add(temp.toCSV());
            ReadAndWriteFile.write(DRONE_LIST, stringList, true);
        }
        if (temp instanceof Car) {
            stringList.add(temp.toCSV());
            ReadAndWriteFile.write(CAR_LIST, stringList, true);
        }
    }

    @Override
    public void handleDisplay() {
        int temp = VehicleView.chooseTypeDisplay();
        if (temp == 1) {
            for (Drone drone : getAllDrone()) {
                System.out.println(drone);
            }
        } else {
            for (Car car : getAllCar()) {
                System.out.println(car);
            }
        }

    }

    @Override
    public void handleDelete() {
        try {
            String id = inputString("Nhập số hiệu đăng kí");
            vehicleList.clear();
            vehicleList.addAll(getAllDrone());
            vehicleList.addAll(getAllCar());
            boolean flag = false;
            for (Vehicle vehicle : vehicleList) {
                if (Objects.equals(vehicle.getIdVehicle(), id)) {
                    while (true) {
                        flag = true;
                        String temp = inputString("Bạn có muốn xóa thật không (Yes/No) ");
                        if (temp.equals("Yes")) {
                            System.out.println("Đã xóa thành công");
                            vehicleList.remove(vehicle);
                            return;
                        }
                        if (temp.equals("No")) {
                            return;
                        }
                    }
                }
            }
            if (!flag) {
                throw new NotFoundVehicleException("Số hiệu không tồn tại");
            }
        } catch (NotFoundVehicleException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void handleFilter() {
        vehicleList.addAll(getAllDrone());
        vehicleList.addAll(getAllCar());
        int type = VehicleView.chooseFilter();
        if (type == 1) {
            boolean flag = false;
            String temp = inputString("Nhập số hiệu");
            for (Vehicle vehicle : vehicleList) {
                if (Objects.equals(vehicle.getIdVehicle(), temp)) {
                    System.out.println(vehicle);
                    flag = true;
                }
            }
            System.out.println(flag ? "Kết quả tìm kiếm" : "Không tìm thấy");
        }
        if (type == 2) {
            boolean flag = false;
            String temp = inputString("Nhập tên người điều phối");
            for (Vehicle vehicle : vehicleList) {
                if (Objects.equals(vehicle.getHuman(), temp)) {
                    System.out.println(vehicle);
                    flag = true;
                }
            }
            System.out.println(flag ? "Kết quả tìm kiếm" : "Không tìm thấy");
        }

    }

    @Override
    public List<Drone> getAllDrone() {
        return Library.getAll(
                DRONE_LIST,
                arr -> new Drone(arr[0], arr[1], Integer.parseInt(arr[2]),
                        arr[3], Integer.parseInt(arr[4]))
        );
    }

    @Override
    public List<Car> getAllCar() {
        return Library.getAll(
                CAR_LIST,
                arr -> new Car(arr[0], arr[1], Integer.parseInt(arr[2]),
                        arr[3], arr[4])
        );
    }


}
