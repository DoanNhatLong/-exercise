package entity;

public class Car extends Vehicle{
    String protect;

    public Car() {
    }


    public Car(String protect) {
        this.protect = protect;
    }

    public Car(String idVehicle, String nameCompany, int year, String human, String protect) {
        super(idVehicle, nameCompany, year, human);
        this.protect = protect;
    }

    @Override
    public String toCSV() {
        return super.toCSV()+","+getProtect();
    }

    @Override
    public String toString() {
        return "Car{" +
                "protect='" + protect + '\'' +
                "} " + super.toString();
    }

    public String getProtect() {
        return protect;
    }

    public void setProtect(String protect) {
        this.protect = protect;
    }
}
