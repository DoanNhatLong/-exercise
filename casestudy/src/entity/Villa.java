package entity;

public class Villa extends Facility{
    private String standardRoom;
    private double areaPool;
    private int numberFloor;

    public Villa() {
    }

    public Villa(String idService, String nameService, Double area, Double price, String style, int numberPeople, String standardRoom, double areaPool, int numberFloor) {
        super(idService, nameService, area, price, style, numberPeople);
        this.standardRoom = standardRoom;
        this.areaPool = areaPool;
        this.numberFloor = numberFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }
}
