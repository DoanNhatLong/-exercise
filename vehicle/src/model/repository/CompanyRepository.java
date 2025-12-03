package model.repository;

import model.entity.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {
    String company;
    static final List<Company> companyList= new ArrayList<>();
    public CompanyRepository() {

    }

    static {
        companyList.add(new Company("1","Toyota", "USA"));
        companyList.add(new Company("2","BMW", "USA"));
        companyList.add(new Company("3","Honda", "USA"));
        companyList.add(new Company("4","Tesla", "USA"));
        companyList.add(new Company("5","Vin", "USA"));
    }

    public static List<Company> getCompanyList() {
        return companyList;
    }


}
