package view;

import entity.Drug;
import ultity.Helper;
import ultity.Library;

import java.text.ParseException;
import java.util.Date;

import static view.RunApp.sdf;

public class DrugView {
    public static Drug inputDrug() throws ParseException {
        String id = Helper.inputString("Nhập ID");
        String name = Helper.inputString("Nhập name");
        Date date = Library.inputDate();
        int input = Helper.inputInt("Nhập số lwuong nhập vào");
        return new Drug(id, name, date, input);
    }

}
