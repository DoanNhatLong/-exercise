package repository;

import entity.Company;

import java.util.List;

public class ListCompany {
    public static List<Company> companyList=List.of(
            new Company("1","Toyota","USA"),
            new Company("2","BMW","USA"),
            new Company("3","Honda","Japan"),
            new Company("4","Vin","Vietnam")
    );
}
