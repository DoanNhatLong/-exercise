package utils;


import static view.RunApp.*;

public class Menu {
    public static final int ADD = 1;
    public static final int DISPLAY = 2;
    //    public static final int DELETE = 3;
    public static final int EDIT = 3;
//    public static final int FILTER = 4;
//    public static final int SORT = 5;
//    public static final int REPORT = 6;
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
//                    case DELETE -> handleDelete();
//                    case FILTER -> handleFilter();
//                    case SORT -> handleSorter();
//                    case REPORT -> handleReport();
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

//    private void handleReport() {
//    }

    protected void handleEdit() {
    }

    protected void handleDisplay() {
    }

    protected void handleAdd() {
    }

//    protected void handleSorter() {
//    }
//
//    protected void handleFilter() {
//    }
//
//    protected void handleDelete() {
//    }

}
