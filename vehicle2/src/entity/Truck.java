package entity;

public class Truck extends Vehicle {
    int load;

    public Truck() {
    }

    public Truck(String idCar, String company, String name, String owner, int load) {
        super(idCar, company, name, owner);
        this.load = load;
    }

    @Override
    public String toCSV() {
        return "Truck," + super.toCSV() + "," + getLoad();
    }

    @Override
    public String toString() {
        return "Truck{" +
                "load=" + load +
                "} " + super.toString();
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }
}
