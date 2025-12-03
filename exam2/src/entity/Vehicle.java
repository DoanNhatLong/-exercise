package entity;

public abstract class Vehicle {
    private String idVehicle;
    private String nameCompany;
    private int year;
    private String human;

    public Vehicle() {
    }

    public Vehicle(String idVehicle, String nameCompany, int year, String human) {
        this.idVehicle = idVehicle;
        this.nameCompany = nameCompany;
        this.year = year;
        this.human = human;
    }

    public String toCSV(){
        return getIdVehicle()+","+getNameCompany()+","+getYear()+","+getHuman();
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "idVehicle='" + idVehicle + '\'' +
                ", nameCompany='" + nameCompany + '\'' +
                ", year=" + year +
                ", human='" + human + '\'' +
                '}';
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getHuman() {
        return human;
    }

    public void setHuman(String human) {
        this.human = human;
    }
}
