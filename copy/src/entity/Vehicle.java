package entity;

public abstract class Vehicle {
    private String idCar;
    private Company name;
    private int year;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(String idCar, Company name, int year, String owner) {
        this.idCar = idCar;
        this.name = name;
        this.year = year;
        this.owner = owner;
    }

    public String toCSV(){
        return getIdCar()+","+getName()+","+getYear()+","+getOwner();
    }

    @Override
    public String toString() {
        return "idCar='" + idCar +
                ", name='" + name +
                ", year=" + year +
                ", owner='" + owner +
                '}';
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public Company getName() {
        return name;
    }

    public void setName(Company name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
