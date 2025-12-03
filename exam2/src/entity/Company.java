package entity;

public class Company {
    String idCompany;
    String nameCompany;
    String country;

    public Company() {
    }

    public Company(String idCompany, String nameCompany, String country) {
        this.idCompany = idCompany;
        this.nameCompany = nameCompany;
        this.country = country;
    }

    public String toCSV(){
        return getIdCompany()+","+getNameCompany()+","+getCountry();
    }

    public String getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Company{" +
                "idCompany='" + idCompany + '\'' +
                ", nameCompany='" + nameCompany + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
