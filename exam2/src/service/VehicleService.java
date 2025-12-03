package service;

import repository.IVehicleRepository;
import repository.VehicleRepository;

public class VehicleService implements IVehicleService {
    IVehicleRepository vehicleRepository = new VehicleRepository();

    @Override
    public void handleAdd() {
        vehicleRepository.handleAdd();
    }

    @Override
    public void handleDisplay() {
        vehicleRepository.handleDisplay();
    }

    @Override
    public void handleDelete() {
        vehicleRepository.handleDelete();
    }

    @Override
    public void handleFilter() {
        vehicleRepository.handleFilter();
    }
}
