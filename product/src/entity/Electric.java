package entity;

public class Electric extends Product{
    int battery;

    public Electric() {
    }

    public Electric(String idProduct, String name, int quantity, String date, int battery) {
        super(idProduct, name, quantity, date);
        this.battery = battery;
    }

    @Override
    public String toCSV() {
        return "Electric,"+ super.toCSV()+","+getBattery();
    }

    @Override
    public String toString() {
        return "Electric{" +
                "battery=" + battery +
                "} " + super.toString();
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }
}
