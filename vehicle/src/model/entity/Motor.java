package model.entity;

import model.entity.Company;

public class Motor extends Vehicle{
    double power;

    public Motor() {
    }

    public Motor(String carID, Company company, String owner, int year, double power) {
        super(carID, company, owner, year);
        this.power = power;
    }

    public Motor(Vehicle vehicle, double power) {
        super(vehicle.getCarID(), vehicle.getCompany(), vehicle.getOwner(), vehicle.getYear());
        this.power = power;
    }

    public Motor(double power) {
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "carID='" + carID + '\'' +
                ", company=" + company +
                ", owner='" + owner + '\'' +
                ", year=" + year +
                ", power=" + power +
                '}';
    }
}
