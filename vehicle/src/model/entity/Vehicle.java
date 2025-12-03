package model.entity;

import model.entity.Company;

public class Vehicle {
    String carID;
    Company company;
    String owner;
    int year;

    public Vehicle() {
    }

    public Vehicle(String carID, Company company, String owner, int year) {
        this.carID = carID;
        this.company = company;
        this.owner = owner;
        this.year = year;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "carID='" + carID + '\'' +
                ", company=" + company +
                ", owner='" + owner + '\'' +
                ", year=" + year +
                '}';
    }
}
