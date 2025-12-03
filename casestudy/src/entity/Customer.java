package entity;

public class Customer extends Person {
    String idCustomer;
    String typeCustomer;
    String address;

    public Customer() {
    }

    public Customer(String idCustomer, String typeCustomer, String address) {
        this.idCustomer = idCustomer;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public Customer(String name, String date, String gender, String idPerson, String tel, String email, String idCustomer, String typeCustomer, String address) {
        super(name, date, gender, idPerson, tel, email);
        this.idCustomer = idCustomer;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer='" + idCustomer + '\'' +
                ", typeCustomer='" + typeCustomer + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }


    public String toCSV() {
        return  name +
                "," + date +
                "," + gender +
                "," + idPerson +
                "," + tel +
                "," + email +
                "," + idCustomer +
                "," + typeCustomer +
                "," + address
                ;
    }
}
