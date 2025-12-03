package model.entity;

public class Company {
    String companyID;
    String companyName;
    String country;

    public Company() {
    }

    public Company(String companyID, String companyName, String country) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.country = country;
    }

    public String getCompanyID() {
        return companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyID='" + companyID + '\'' +
                ", companyName='" + companyName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
