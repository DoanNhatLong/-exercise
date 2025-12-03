package model.service;

import model.entity.Vehicle;
import model.repository.IVehicleRepository;
import model.repository.VehicleRepository;

import java.util.List;

public class VehicleService implements IVehicleService{
    public static IVehicleRepository repo=new VehicleRepository();

    @Override
    public List<List<? extends Vehicle>> getAll() {
        return repo.getAll();
    }

    @Override
    public void add(Vehicle vehicle) {
        repo.add(vehicle);
    }
}
