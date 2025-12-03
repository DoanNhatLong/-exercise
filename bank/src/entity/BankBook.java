package entity;

public class BankBook {
    private String id;
    private String name;
    private String idPerson;
    private String address;
    private String phone;
    private String date;
    private float moneyInput;
    private String type;
    private int extend;

    public BankBook() {
    }

    public BankBook(String id, String name, String idPerson, String address, String phone, String date, float moneyInput, String type, int extend) {
        this.id = id;
        this.name = name;
        this.idPerson = idPerson;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.moneyInput = moneyInput;
        this.type = type;
        this.extend = extend;
    }

    public String toCSV(){
        return getId()+","+getName()+","+getIdPerson()+","+getAddress()+","+getPhone()+","
                +getDate()+","+getMoneyInput()+","+getType()+","+getExtend();
    }

    @Override
    public String toString() {
        return "BankBook{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", moneyInput=" + moneyInput +
                ", type='" + type + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getMoneyInput() {
        return moneyInput;
    }

    public void setMoneyInput(float moneyInput) {
        this.moneyInput = moneyInput;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getExtend() {
        return extend;
    }

    public void setExtend(int extend) {
        this.extend = extend;
    }
}
