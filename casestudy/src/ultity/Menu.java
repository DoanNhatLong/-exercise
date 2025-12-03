package ultity;

import static controller.FuramaController.sc;

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
}
