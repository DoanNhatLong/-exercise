package entity;

public class Vehicle {
    private String idCar;
    private String company;
    private String name;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(String idCar, String company, String name, String owner) {
        this.idCar = idCar;
        this.company = company;
        this.name = name;
        this.owner = owner;
    }

    public String toCSV() {
        return getIdCar() + "," + getCompany() + "," + getName() + "," + getOwner();
    }

    @Override
    public String toString() {
        return "company='" + company +
                ", name='" + name +
                ", owner='" + owner +
                '}';
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
