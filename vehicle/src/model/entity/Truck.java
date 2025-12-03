package model.entity;

import model.entity.Company;

public class Truck extends Vehicle {
    double load;

    public Truck() {
    }

    public Truck(double load) {
        this.load = load;
    }

    public Truck(String carID, Company company, String owner, int year, double load) {
        super(carID, company, owner, year);
        this.load = load;
    }

    public Truck(Vehicle vehicle, double load) {
        super(vehicle.getCarID(), vehicle.getCompany(), vehicle.getOwner(), vehicle.getYear());
        this.load = load;
    }


    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "carID='" + carID + '\'' +
                ", company=" + company +
                ", owner='" + owner + '\'' +
                ", year=" + year +
                ", load=" + load +
                '}';
    }
}
