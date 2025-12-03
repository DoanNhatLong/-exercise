package entity;

public class Oto extends Vehicle{
    private int seat;
    private String style;

    public Oto() {
    }

    public Oto(int seat, String style) {
        this.seat = seat;
        this.style = style;
    }

    public Oto(String idCar, Company name, int year, String owner, int seat, String style) {
        super(idCar, name, year, owner);
        this.seat = seat;
        this.style = style;
    }

    @Override
    public String toCSV() {
        return "Oto,"+ super.toCSV()+","+getSeat()+","+getStyle() ;
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
