package entity;

public class Company {
    String idCompany;
    String name;
    String country;

    public Company() {
    }

    public Company(String idCompany, String name, String country) {
        this.idCompany = idCompany;
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return "{"+getIdCompany()+"-"+getName()+"-"+getCountry()+"}";
    }

    public String getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
