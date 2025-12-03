package model.service;

import model.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<List<? extends Vehicle>> getAll();
    void add(Vehicle vehicle);
}
