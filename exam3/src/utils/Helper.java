package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static view.RunApp.sc;

public class Helper {
    //    ^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$
    //    ^[_a-z0-9]{6,}$
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 1000000000;
    public static final String ERROR_VOID = "Không được để trống, nhập lại.";
    public static final String ERROR_NUMBER = "Vui lòng nhập số hợp lệ ";
    public static final String ERROR_SPEC = "Không được chứa ký tự đặc biệt.";
    public static final String ERROR_DATE = "Ngày không hợp lệ, Định dạng dd/MM/yyyy.";
    public static final String ERROR_INPUT = "Lỗi nhập liệu, vui lòng thử lại.";

    public static int inputInt(String message, int MIN_VALUE, int MAX_VALUE) {
        while (true) {
            System.out.println(message);

            try {
                String raw = sc.nextLine().trim();

                if (raw.isEmpty()) {
                    System.out.println(ERROR_VOID);
                    continue;
                }

                if (!raw.matches("\\d+")) {
                    System.out.println(ERROR_NUMBER);
                    continue;
                }

                int value = Integer.parseInt(raw);

                if (value < MIN_VALUE || value > MAX_VALUE) {
                    System.out.println("Giá trị phải nằm trong khoảng " + MIN_VALUE + " đến " + MAX_VALUE + ".");
                    continue;
                }

                return value;

            } catch (Exception e) {
                System.out.println(ERROR_INPUT);
            }
        }
    }

    public static int inputInt(String message) {
        while (true) {
            System.out.println(message);

            try {
                String raw = sc.nextLine().trim();

                if (raw.isEmpty()) {
                    System.out.println(ERROR_VOID);
                    continue;
                }

                if (!raw.matches("\\d+")) {
                    System.out.println(ERROR_NUMBER);
                    continue;
                }

                return Integer.parseInt(raw);

            } catch (Exception e) {
                System.out.println(ERROR_INPUT);
            }
        }
    }

    public static int inputInt(String message, int MIN_VALUE) {
        while (true) {
            System.out.println(message);

            try {
                String raw = sc.nextLine().trim();

                if (raw.isEmpty()) {
                    System.out.println(ERROR_VOID);
                    continue;
                }

                if (!raw.matches("\\d+")) {
                    System.out.println(ERROR_NUMBER);
                    continue;
                }

                int value = Integer.parseInt(raw);

                if (value <= MIN_VALUE) {
                    System.out.println("Giá trị phải lớn hơn" + MIN_VALUE);
                    continue;
                }

                return value;

            } catch (Exception e) {
                System.out.println(ERROR_INPUT);
            }
        }
    }

    public static double inputDouble(String message) {
        while (true) {
            System.out.println(message);

            try {
                String raw = sc.nextLine().trim();

                if (raw.isEmpty()) {
                    System.out.println(ERROR_VOID);
                    continue;
                }

                if (!raw.matches("\\d+")) {
                    System.out.println(ERROR_NUMBER);
                    continue;
                }

                return Double.parseDouble(raw);

            } catch (Exception e) {
                System.out.println(ERROR_INPUT);
            }
        }
    }

    public static double inputDouble(String message, int MIN_VALUE) {
        while (true) {
            System.out.println(message);

            try {
                String raw = sc.nextLine().trim();

                if (raw.isEmpty()) {
                    System.out.println(ERROR_VOID);
                    continue;
                }

                if (!raw.matches("\\d+")) {
                    System.out.println(ERROR_NUMBER);
                    continue;
                }

                int value = Integer.parseInt(raw);

                if (value <= MIN_VALUE) {
                    System.out.println("Giá trị phải lớn hơn  " + MIN_VALUE);
                    continue;
                }

                return value;

            } catch (Exception e) {
                System.out.println(ERROR_INPUT);
            }
        }
    }

    public static String inputString(String message) {
        while (true) {
            System.out.println(message);

            try {
                String raw = sc.nextLine().trim();

                if (raw.isEmpty()) {
                    System.out.println(ERROR_VOID);
                    continue;
                }

                return raw;

            } catch (UserException e) {
                System.out.println(ERROR_INPUT);
            }
        }
    }

    public static String inputValidDate(String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        while (true) {
            System.out.print(message);
            String raw = sc.nextLine().trim();

            if (raw.isEmpty()) {
                System.out.println(ERROR_VOID);
                continue;
            }

            if (!raw.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
                System.out.println(ERROR_DATE);
                continue;
            }

            String[] parts = raw.split("/");
            String day = parts[0].length() == 1 ? "0" + parts[0] : parts[0];
            String month = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
            String year = parts[2];
            String formatted = day + "/" + month + "/" + year;

            try {
                Date date = sdf.parse(formatted);
                return formatted;
            } catch (Exception e) {
                System.out.println(ERROR_DATE);
            }
        }
    }

    public static <T> void displayList(List<T> list) {
        List<T> tempList = getAll();
        for (T item : tempList) {
            System.out.println(item);
        }
    }

    public static Date parseDate(String str) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> List<T> getAll() {
        return null;
    }

    public static String inputWithQuit(String prompt, Scanner sc) {
        System.out.println(prompt + " (gõ 'quit' để hủy):");
        String input = sc.nextLine().trim();
        if (input.equalsIgnoreCase("quit")) {
            return null;
        }
        return input;
    }

//        public static void showMenu() {
//            IBankService bankService = new BankService();
//            final int ADD = 1;
//            final int DISPLAY = 2;
//            final int FIND_BY_TYPE = 3;
//            final int FIND_BY_DATE = 4;
//            final int UPDATED = 5;
//            final int SORT = 6;
//            final int EXIT = 7;
//            Scanner sc = new Scanner(System.in);
//            while (true) {
//                System.out.println("------Quanr lý phương tiện----");
//                System.out.println("Chọn chức năng");
//                System.out.println("""
//                    1. Thêm
//                    2. Hiển thị
//                    3. Tìm theo loại tài khoản
//                    4. Tìm theo ngày
//                    5. Cập nhập
//                    6. Sắp xếp
//                    7. Thoát""");
//                int choice = Integer.parseInt(sc.nextLine());
//                switch (choice) {
//                    case ADD -> bankService.handleAdd();
//                    case DISPLAY -> bankService.handleDisplay();
//                    case FIND_BY_TYPE -> bankService.handleFindByType();
//                    case FIND_BY_DATE -> bankService.handleFindByDate();
//                    case UPDATED -> bankService.handleUpdated();
//                    case SORT -> bankService.handleSort();
//                    case EXIT -> {
//                        return;
//                    }
//                }
//            }
//        }


}
