package entity;

public class Drone extends Vehicle{
    int flyMax;

    public Drone() {
    }

    public Drone(int flyMax) {
        this.flyMax = flyMax;
    }

    public Drone(String idVehicle, String nameCompany, int year, String human, int flyMax) {
        super(idVehicle, nameCompany, year, human);
        this.flyMax = flyMax;
    }

    @Override
    public String toCSV() {
        return super.toCSV()+","+getFlyMax();
    }

    @Override
    public String toString() {
        return "Drone{" +
                "flyMax=" + flyMax +
                "} " + super.toString();
    }

    public int getFlyMax() {
        return flyMax;
    }

    public void setFlyMax(int flyMax) {
        this.flyMax = flyMax;
    }
}
