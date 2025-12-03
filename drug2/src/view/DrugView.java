package view;

import entity.Drug;
import ultity.Helper;
import ultity.Library;
import ultity.UserException;

import static ultity.Helper.inputString;

public class DrugView {
    public static Drug inputDrug() {
        String id = inputString("Nhập ID");
        String name = inputString("Nhập tên thuốc");
        String date = inputDate();
        int input = inputInput();
        return new Drug(id, name, date, input);
    }

    public static int inputInput() {
        return Library.inputWithValidator(
                ()->Helper.inputInt("Nhập vào hàng nhập (>0)"),
                UserException::validateInput
        );
    }

    public static String inputDate() {
        return Library.inputWithValidator(
                ()->Helper.inputString("Nhập vào ngày hết hạn (dd/MM/yyyy)"),
                UserException::validateFutureDate
        );
    }
}
