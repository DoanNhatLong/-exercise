package service;

import entity.Vehicle;
import repository.IVehicleRepository;
import repository.VehicleRepository;
import ultity.Helper;
import view.VehicleView;

public class VehicleService implements IVehicleService {
    IVehicleRepository vehicleRepository=new VehicleRepository();

    @Override
    public void handleDisplay() {
        vehicleRepository.handleDisplay();
    }

    @Override
    public void handleAdd() {
        Vehicle temp= VehicleView.inputVehicle();
        vehicleRepository.handleAdd(temp);

    }

    @Override
    public void handleFilter() {
        String id = "";
        vehicleRepository.handleFilter(id);

    }

    @Override
    public void handleDelete() {
        String id= Helper.inputString("Nhập id muốn xóa");
        vehicleRepository.handleDelete(id);

    }
}
