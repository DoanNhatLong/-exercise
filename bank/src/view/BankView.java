package view;

import entity.BankBook;
import repository.ListToInput;
import ultity.Helper;
import ultity.Library;
import ultity.UserException;

import java.util.List;

public class BankView {
    public static BankBook inputBankBook(){
        String id= inputID();
        String name=Helper.inputString("Nhập tên");
        String idPerson=Helper.inputString("Nhập số căn cước");
        String address=Helper.inputString("Nhập địa chỉ");
        String phone=inputPhone();
        String date=inputDate();
        double money=Helper.inputDouble("Nhập số tiền gửi");
        String type= Library.readOptionByIndex(ListToInput.type, "Lựa chọn kiểu");
        int extend= Helper.inputInt("""
                Mời lựa chọn
                0. Không tự gia hạn
                1. Tự gia hạn""", 0,1);
        return new BankBook(id,name,idPerson,address,phone,date, (float) money,type,extend);
    }

    static String inputID() {
        while (true) {
            try {
                String temp = Helper.inputString("Nhập vào ID(STKxxxx)");
                UserException.validateID(temp);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static String inputPhone() {
        while (true) {
            try {
                String temp = Helper.inputString("Nhập điện thoại");
                UserException.validatePhone(temp);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static String inputDate(){
        while (true) {
            try {
                String temp = Helper.inputString("Nhập ngày nhận");
                UserException.validateFutureDate(temp);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }

    }


}
