package entity;

public class Oto extends Vehicle {
    int seat;
    String style;

    public Oto() {
    }

    public Oto(String idCar, String company, String name, String owner, int seat, String style) {
        super(idCar, company, name, owner);
        this.seat = seat;
        this.style = style;
    }

    @Override
    public String toCSV() {
        return "Oto," + super.toCSV() + "," + getSeat() + "," + getStyle();
    }

    @Override
    public String toString() {
        return "Oto{" +
                "seat=" + seat +
                ", style='" + style + '\'' +
                "} " + super.toString();
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
