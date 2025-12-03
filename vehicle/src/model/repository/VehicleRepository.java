package model.repository;

import model.entity.*;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository implements IVehicleRepository {
    static final List<Oto> otoList = new ArrayList<>();
    static final List<Motor> motorList = new ArrayList<>();
    static final List<Truck> truckList = new ArrayList<>();
    static final List<List<? extends Vehicle>> vehicleList = new ArrayList<>();

    static {
        otoList.add(new Oto("12", CompanyRepository.getCompanyList().get(0), "Hung", 2000, "Sport", 8));
        truckList.add(new Truck("12", CompanyRepository.getCompanyList().get(1), "Hung", 2000, 899));
        vehicleList.add(motorList);
        vehicleList.add(truckList);
        vehicleList.add(otoList);
    }


    @Override
    public List<List<? extends Vehicle>> getAll() {
        return vehicleList;
    }

    @Override
    public void add(Vehicle vehicle) {
        if (vehicle instanceof Oto) {
            otoList.add((Oto) vehicle);
        } else if (vehicle instanceof Motor) {
            motorList.add((Motor) vehicle);
        } else if (vehicle instanceof Truck){
            truckList.add((Truck) vehicle);
        }

    }
}
