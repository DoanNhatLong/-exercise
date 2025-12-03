package entity;

public class Product {
    private String idProduct;
    private String name;
    private int quantity;
    private String date;

    public Product() {
    }

    public Product(String idProduct, String name, int quantity, String date) {
        this.idProduct = idProduct;
        this.name = name;
        this.quantity = quantity;
        this.date = date;
    }

    public String toCSV(){
        return getIdProduct()+","+getName()+","+getQuantity()+","+getDate();
    }

    @Override
    public String toString() {
        return "idProduct='" + idProduct + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", date='" + date + '\'' +
                '}';
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
