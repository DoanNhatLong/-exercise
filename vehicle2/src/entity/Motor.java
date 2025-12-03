package entity;

public class Motor extends Vehicle{
    double power;

    public Motor() {
    }

    public Motor(String idCar, String company, String name, String owner, double power) {
        super(idCar, company, name, owner);
        this.power = power;
    }

    @Override
    public String toCSV() {
        return "Motor,"+ super.toCSV()+","+getPower();
    }

    @Override
    public String toString() {
        return "Motor{" +
                "power=" + power +
                "} " + super.toString();
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
