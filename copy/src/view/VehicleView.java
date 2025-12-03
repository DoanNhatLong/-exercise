package view;

import entity.*;
import repository.ListCompany;
import ultity.Helper;
import ultity.Library;

public class VehicleView {
    public static Vehicle inputVehicle() {
        int type = inputType();
        String id = Helper.inputString("Nhập biến xe");
        Company name = Library.readOptionByIndex(ListCompany.companyList, "Chọn tên công ty(1-4)");
        int year = Helper.inputInt("Nhập năm");
        String owner = Helper.inputString("Nhập chủ sở hữa");
        switch (type) {
            case 1 -> {
                double load=Helper.inputDouble("Nhập tải trọng");
                return new Truck(id,name,year,owner,load);
                 }
            case 2 -> {
                int seat=Helper.inputInt("Nhập số chỗ ngồi");
                String style=Helper.inputString("NHập kiểu xe");
                return new Oto(id,name,year,owner,seat,style);
            }
            case 3 ->{
                double power=Helper.inputDouble("Nhập công suất");
                return new Motor(id,name,year,owner,power);
            }
        }
        return null;
    }

    public static int inputType() {
        System.out.println("------MENU------");
        System.out.println("""
                1. Xe tải
                2. Oto
                3. Motor""");
        return Helper.inputInt("Nhập lựa chọn", 1, 3);
    }



    public static Company parseCompany(String str) {
        str = str.replace("{", "").replace("}", "");
        String[] parts = str.split("-");
        return new Company(parts[0].trim(), parts[1].trim(), parts[2].trim());
    }


}
