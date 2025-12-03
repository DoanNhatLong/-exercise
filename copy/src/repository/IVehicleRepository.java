package repository;

import entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    void handleDisplay();

    void handleAdd( Vehicle temp);

    void handleFilter(String id);

    void handleDelete(String id);

    List<Vehicle> getAll();
}
