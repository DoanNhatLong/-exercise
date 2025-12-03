package repository;

import entity.Car;
import entity.Drone;
import entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    void handleAdd();

    void handleDisplay();

    void handleDelete();

    void handleFilter();

    List<Drone> getAllDrone();
    List<Car> getAllCar();

}
