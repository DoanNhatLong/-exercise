package entity;

import java.util.Objects;

public abstract class Facility {
    private String idService;
    private String nameService;
    private Double area;
    private Double price;
    private String style;
    private int numberPeople;

    public Facility() {
    }

    public Facility(String idService) {
        this.idService = idService;
    }

    public Facility(String idService, String nameService, Double area, Double price, String style, int numberPeople) {
        this.idService = idService;
        this.nameService = nameService;
        this.area = area;
        this.price = price;
        this.style = style;
        this.numberPeople = numberPeople;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }

    @Override
    public String toString() {
        return "idService='" + idService + '\'' +
                ", area=" + area +
                ", style='" + style + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Objects.equals(idService, facility.idService);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idService);
    }
}
