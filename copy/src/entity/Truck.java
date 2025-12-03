package entity;

public class Truck extends Vehicle{
    private double loaded;

    public Truck() {
    }

    public Truck(String idCar, Company name, int year, String owner, double loaded) {
        super(idCar, name, year, owner);
        this.loaded = loaded;
    }

    @Override
    public String toCSV() {
        return "Truck,"+ super.toCSV()+","+getLoaded();
    }

    @Override
    public String toString() {
        return "Truck{" +
                "loaded=" + loaded +
                "} " + super.toString();
    }

    public double getLoaded() {
        return loaded;
    }

    public void setLoaded(double loaded) {
        this.loaded = loaded;
    }
}
