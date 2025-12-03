package entity;

public class Motor extends Vehicle{
    private double power;

    public Motor() {
    }

    public Motor(double power) {
        this.power = power;
    }

    public Motor(String idCar, Company name, int year, String owner, double power) {
        super(idCar, name, year, owner);
        this.power = power;
    }

    @Override
    public String toCSV() {
        return "Motor,"+super.toCSV()+","+getPower();
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
