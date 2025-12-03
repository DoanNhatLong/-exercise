package entity;

public class Room extends Facility{
    String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String idService, String nameService, Double area, Double price, String style, int numberPeople, String freeService) {
        super(idService, nameService, area, price, style, numberPeople);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
}
