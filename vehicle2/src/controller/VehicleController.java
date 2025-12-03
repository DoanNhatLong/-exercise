package controller;

import service.IVehicleService;
import service.VehicleService;
import ultity.Menu;

public class VehicleController extends Menu {
    IVehicleService vehicleService=new VehicleService();
    public static void showMenu(){

        new VehicleController().showMenu("Vehicle");
    }

    @Override
    protected void handleDisplay() {
       vehicleService.handleDisplay();
    }

    @Override
    protected void handleAdd() {
       vehicleService.handleAdd();
    }

    @Override
    protected void handleFilter() {
       vehicleService.handleFilter();
    }

    @Override
    protected void handleDelete() {
       vehicleService.handleDelete();
    }
}
