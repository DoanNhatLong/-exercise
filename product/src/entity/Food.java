package entity;

public class Food extends Product{
    String expired;


    public Food() {
    }

    public Food(String idProduct, String name, int quantity, String date, String expired) {
        super(idProduct, name, quantity, date);
        this.expired = expired;
    }

    @Override
    public String toCSV() {
        return "Food,"+ super.toCSV()+","+getExpired();
    }

    @Override
    public String toString() {
        return "Food{" +
                "expired='" + expired + '\'' +
                "} " + super.toString();
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }
}
