package entity;

public class HouseHold extends Product{
    String material;

    public HouseHold() {
    }

    public HouseHold(String idProduct, String name, int quantity, String date, String material) {
        super(idProduct, name, quantity, date);
        this.material = material;
    }

    @Override
    public String toCSV() {
        return "HouseHold,"+ super.toCSV()+","+getMaterial();
    }

    @Override
    public String toString() {
        return "HouseHold{" +
                "material='" + material + '\'' +
                "} " + super.toString();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
