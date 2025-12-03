package view;

import controller.LibraryController;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class RunApp {
    public static final String ERROR_VOID = "Không được để trống, nhập lại.";
    public static final String ERROR_NUMBER = "Vui lòng nhập số hợp lệ ";
    public static final String ERROR_SPEC = "Không được chứa ký tự đặc biệt.";
    public static final String ERROR_DATE = "Ngày không hợp lệ, định dạng dd/MM/yyyy.";
    public static final String ERROR_INPUT = "Lỗi nhập liệu, vui lòng thử lại.";
    public static final Scanner sc = new Scanner(System.in);
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final SimpleDateFormat sdfFromCSV = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

    public static void main(String[] args) {
        LibraryController.showMenu();
    }
}
