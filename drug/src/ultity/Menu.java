package ultity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import static view.RunApp.sc;

public class Menu {
    public static final String ERROR_VOID = "Không được để trống, nhập lại.";
    public static final String ERROR_NUMBER = "Vui lòng nhập số hợp lệ ";
    public static final String ERROR_SPEC = "Không được chứa ký tự đặc biệt.";
    public static final String ERROR_DATE = "Ngày không hợp lệ. Định dạng dd/MM/yyyy.";
    public static final String ERROR_INPUT = "Lỗi nhập liệu, vui lòng thử lại.";
    public static final int ADD = 1;
    public static final int DISPLAY = 2;
    //    public static final int DELETE = 3;
    public static final int EDIT = 3;
    //    public static final int FILTER = 4;
//    public static final int SORT = 5;
    public static final int RETURN = 0;
    public static String[] createMenu(String itemName) {
        int[] options = {ADD, DISPLAY, EDIT, RETURN};
        String[] actions = {"Add", "Display", "Edit", "Return"};

        String[] menu = new String[options.length];
        for (int i = 0; i < options.length; i++) {
            menu[i] = options[i] + ". " + actions[i] + (options[i] == RETURN ? "" : " " + itemName);
        }
        return menu;
    }

    public void showMenu(String itemName) {
        String[] menu = createMenu(itemName);

        while (true) {
            System.out.println("------MENU------");
            for (String item : menu) {
                System.out.println(item);
            }
            System.out.println("----------------");
            System.out.print("Chọn chức năng: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case ADD -> handleAdd();
                    case DISPLAY -> handleDisplay();
                    case EDIT -> handleEdit();
//                    case DELETE ->  handleDelete();
//                    case FILTER -> handleFilter();
//                    case SORT -> handleSorter();
                    case RETURN -> {
                        return;
                    }
                    default -> System.out.println(ERROR_NUMBER);
                }

            } catch (NumberFormatException e) {
                System.out.println(ERROR_INPUT);
            }
        }
    }

    protected void handleEdit() {
    }

    protected void handleDisplay() {
    }

    protected void handleAdd() {
    }

    protected void handleSorter() {
    }

    protected void handleFilter() {
    }

    protected void handleDelete() {
    }

    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat sdfo = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

//    public static void showMenu() throws ParseException {
//        final int ADD_FULL_TIME = 1;
//        final int ADD_PART_TIME = 2;
//        final int ADD_INTERN = 3;
//        final int DISPLAY_ALL = 4;
//        final int SEARCH_BY_NAME = 5;
//        final int DELETE_BY_NAME = 6;
//        final int EXIT = 7;
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println("------Quản lý phương tiện----");
//            System.out.println("Chọn chức năng");
//            System.out.println("""
//                    1. Thêm fulltime
//                    2. Thêm parttime
//                    3. Thêm intern
//                    4. Hiển thị
//                    5. Tìm kiếm
//                    6. Thoát""");
//            int choice = Integer.parseInt(sc.nextLine());
//            switch (choice) {
//                case ADD_FULL_TIME ->
//                case ADD_PART_TIME ->
//                case ADD_INTERN ->
//                case DISPLAY_ALL ->
//                case SEARCH_BY_NAME ->
//                case DELETE_BY_NAME ->
//                case EXIT -> {
//                    return;
//                }
//            }
//
//        }
//    }
}
