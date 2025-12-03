package view;

import model.entity.Company;
import model.entity.Vehicle;
import model.repository.CompanyRepository;

import java.util.Scanner;

public class InputFirst {
    public static Vehicle inputFirst() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id");
        String id = sc.nextLine();
        Company company = null;
        System.out.println("Chọn công ty");
        while (company == null) {
            System.out.println("""
                    1. Toyota
                    2. BMW
                    3. Honda
                    4. Tesla
                    5. Vin""");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> company = CompanyRepository.getCompanyList().get(0);
                case 2 -> company = CompanyRepository.getCompanyList().get(1);
                case 3 -> company = CompanyRepository.getCompanyList().get(2);
                case 4 -> company = CompanyRepository.getCompanyList().get(3);
                case 5 -> company = CompanyRepository.getCompanyList().get(4);
            }
        }
        System.out.println("Nhập chủ");
        String owner = sc.nextLine();
        System.out.println("Nhập năm");
        int year = Integer.parseInt(sc.nextLine());
        return new Vehicle(id,company,owner,year);
    }
}
