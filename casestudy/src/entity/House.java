package entity;

import java.util.Objects;

public class House extends Facility{
    private String standardRoom;
    private int numberFloor=2;

    public House() {
    }

    public House(String standardRoom, int numberFloor) {
        this.standardRoom = standardRoom;
        this.numberFloor = numberFloor;
    }

    public House(String idService, String nameService, Double area, Double price, String style, int numberPeople, String standardRoom, int numberFloor) {
        super(idService, nameService, area, price, style, numberPeople);
        this.standardRoom = standardRoom;
        this.numberFloor = numberFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return numberFloor == house.numberFloor;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numberFloor);
    }
}
