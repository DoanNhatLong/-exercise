package model.repository;

import model.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<List<? extends Vehicle>> getAll();
    void add(Vehicle vehicle);
}
