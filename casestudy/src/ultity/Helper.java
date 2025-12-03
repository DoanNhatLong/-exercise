package ultity;

import view.UserException;

import java.text.SimpleDateFormat;
import java.util.*;

import static controller.FuramaController.sc;

public class Helper {
    //    ^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$
//    ^[_a-z0-9]{6,}$
    public static final String ERROR_VOID = "Không được để trống, nhập lại.";
    public static final String ERROR_NUMBER = "Vui lòng nhập số hợp lệ ";
    public static final String ERROR_SPEC = "Không được chứa ký tự đặc biệt1.";
    public static final String ERROR_DATE = "Ngày không hợp lệ. Định dạng dd/MM/yyyy.";
    public static final String ERROR_INPUT = "Lỗi nhập liệu, vui lòng thử lại.";
    public static int inputInt(String message, int MIN_VALUE, int MAX_VALUE) {
        while (true) {
            System.out.println(message);

            try {
                String raw = sc.nextLine().trim();

                if (raw.isEmpty()) {
                    throw new UserException(ERROR_VOID);
                }

                if (!raw.matches("\\d+")) {
                    throw new UserException(ERROR_NUMBER);
                }

                int value = Integer.parseInt(raw);

                if (value < MIN_VALUE || value > MAX_VALUE) {
                    throw new UserException("Giá trị phải nằm trong khoảng " + MIN_VALUE + " đến " + MAX_VALUE + ".");
                }

                return value;

            } catch (UserException e) {
                System.out.println( e.getMessage());
            }
        }
    }

    public static int inputInt(String message) {
        while (true) {
            System.out.println(message);

            String raw = sc.nextLine().trim();

            if (raw.isEmpty()) {
                System.out.println(ERROR_VOID);
                continue;
            }

            try {
                return Integer.parseInt(raw);

            } catch (NumberFormatException e) {
                System.out.println(ERROR_NUMBER);
            }
        }
    }

    public static double inputDouble(String message, double MIN_VALUE, double MAX_VALUE) {
        while (true) {
            System.out.println(message);

            try {
                String raw = sc.nextLine().trim();

                if (raw.isEmpty()) {
                    System.out.println(ERROR_VOID);
                    continue;
                }

                if (!raw.matches("-?\\d+(\\.\\d+)?")) {
                    System.out.println(ERROR_NUMBER);
                    continue;
                }

                double value = Double.parseDouble(raw);

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

    public static double inputDouble(String message) {
        while (true) {
            System.out.println(message);

            String raw = sc.nextLine().trim();

            if (raw.isEmpty()) {
                System.out.println(ERROR_VOID);
                continue;
            }

            try {
                return Double.parseDouble(raw);

            } catch (NumberFormatException e) {
                System.out.println(ERROR_NUMBER);
            }
        }
    }

    public static String inputString(String message) {
        while (true) {
            System.out.println(message);
            String raw = sc.nextLine().trim();
            if (raw.isEmpty()) {
                System.out.println("Lỗi: Không được để trống!");
            } else {
                return raw;
            }
        }
    }

    public static String inputStringNoSpec(String message) {
        while (true) {
            System.out.println(message);

            try {
                String raw = sc.nextLine().trim();

                if (raw.isEmpty()) {
                    throw new UserException(ERROR_VOID);
                }

                if (!raw.matches("[A-Za-z0-9 ]+")) {
                    throw new UserException(ERROR_SPEC);
                }

                return raw;

            } catch (Exception e) {
                System.out.println(ERROR_INPUT);
            }
        }
    }

    public static String inputValidDate(String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        while (true) {
            System.out.println(message);
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


    public static <T> void display(Collection<T> collection) {
        for (T item : collection) {
            System.out.println(item);
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

}
