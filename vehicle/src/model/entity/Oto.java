package model.entity;

import model.entity.Company;

public class Oto extends Vehicle {
    String style;
    int seat;

    public Oto() {
    }

    public Oto(String carID, Company company, String owner, int year, String style, int seat) {
        super(carID, company, owner, year);
        this.style = style;
        this.seat = seat;
    }

    public Oto(Vehicle vehicle, String style, int seat) {
        super(vehicle.getCarID(), vehicle.getCompany(), vehicle.getOwner(), vehicle.getYear());
        this.style = style;
        this.seat = seat;
    }


    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Oto{" +
                "carID='" + carID + '\'' +
                ", company=" + company +
                ", owner='" + owner + '\'' +
                ", year=" + year +
                ", style='" + style + '\'' +
                ", seat=" + seat +
                '}';
    }
}
