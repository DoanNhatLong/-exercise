package repository;

import entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    void handleDisplay();

    void handleAdd();

    void handleFilter();

    void handleDelete();

    List<Vehicle> getAll();
}
