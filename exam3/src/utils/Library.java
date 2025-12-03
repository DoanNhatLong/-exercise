package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import static view.RunApp.ERROR_NUMBER;
import static view.RunApp.sc;

public class Library {

//    public static String  inputIdEmployee(){
//        while (true) {
//            try {
//                String temp = Helper.inputString("Nhập ID nhân viên");
//                UserException.validateEmployeeCode(temp);
//                return temp;
//            } catch (UserException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }

    public static <T> boolean handleDelete(
            List<T> list,
            Predicate<T> condition,
            Function<T, String> toCSV,
            String filePath
    ) {
        boolean removed = list.removeIf(condition);

        if (removed) {
            List<String> data = new ArrayList<>();
            for (T item : list) {
                data.add(toCSV.apply(item));
            }
            ReadAndWriteFile.write(filePath, data, false);
        }

        return removed;
    }

    public static <T> List<T> getAll(
            String filePath,
            Function<String[], T> mapper
    ) {
        List<String> stringList = ReadAndWriteFile.readFileCSVToStringList(filePath);
        List<T> result = new ArrayList<>();

        for (String line : stringList) {
            String[] arr = line.split(",");
            result.add(mapper.apply(arr));
        }

        return result;
    }

    public static <T> List<T> findByDate(
            List<T> list,
            LocalDate date,
            Function<T, LocalDate> getter
    ) {
        List<T> result = new ArrayList<>();

        for (T item : list) {
            if (getter.apply(item).isBefore(date)) {
                result.add(item);
            }
        }

        return result;
    }

    public static <T> List<T> findByCondition(
            List<T> list,
            String keyword,
            Function<T, String> getter
    ) {
        List<T> result = new ArrayList<>();

        for (T item : list) {
            String field = getter.apply(item);
            if (field != null && field.contains(keyword)) {
                result.add(item);
                System.out.println(item);
            }
        }

        return result;
    }

    public static <T> T inputWithValidator(Supplier<T> inputFunc, Consumer<T> validator) {
        while (true) {
            try {
                T value = inputFunc.get();
                validator.accept(value);
                return value;
            } catch (UserException e) {
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập lại!\n");
            }
        }
    }

    public static <T> List<T> getAll(
            String filePath,
            Map<String, Function<String[], T>> parsers
    ) {
        List<String> stringList = ReadAndWriteFile.readFileCSVToStringList(filePath);
        List<T> result = new ArrayList<>();

        for (String line : stringList) {
            String[] arr = line.split(",");
            result.add(parsers.get(arr[0]).apply(arr));
        }

        return result;
    }


//    public void handleSort() {
//        List<BankBook> bankList = getAll();
//        bankList.sort(Comparator
//                .comparing((BankBook b) -> LocalDate.parse(b.getDate(), formatter))
//                .thenComparing(BankBook::getMoneyInput)
//                .reversed()
//        );
//        for (BankBook bankBook : bankList) {
//            System.out.println(bankBook);
//        }
//    }




//    public void addEmployee(Employee temp) {
//        List<String> stringList=new ArrayList<>();
//        stringList.add(temp.toCSV());
//        ReadAndWriteFile.write(EMPLOYEE_LIST,stringList,true);
//    }

    public static <T> T inputData(Supplier<T> inputFunction, Consumer<T> validateFunction) {
        while (true) {
            try {
                T value = inputFunction.get();
                validateFunction.accept(value);
                return value;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    //    public static String inputStringDate() {
//        while (true) {
//            try {
//                String temp = Helper.inputString("Nhập ngày sinh");
//                UserException.validateBirthDate(temp);
//                return temp;
//            } catch (UserException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }

//    public static Company parseCompany(String str) {
//        // str: "2,BMW,USA"
//        String[] parts = str.split(",", 3); // tách thành 3 phần
//        String id = parts[0];
//        String name = parts[1];
//        String country = parts[2];
//        return new Company(id, name, country);
//    }



//    public List<Employee> getAll() throws ParseException {
//        List<String> stringList = ReadAndWriteFile.readFileCSVToStringList(EMPLOYEE_LIST);
//        List<Employee> employeeList = new ArrayList<>();
//        for (int i = 0; i < stringList.size(); i++) {
//            String string = stringList.get(i);
//            String[] arr = string.split(",");
//            String generatedId = "100" + (i+1);
//            switch (arr[0]){
//                case "FullTime"->employeeList.add(new FullTime(generatedId, arr[1],arr[2],
//                        sdfo.parse(arr[3]),arr[4], arr[5], Double.parseDouble(arr[6]), arr[7]));
//                case "Intern" -> employeeList.add(new Intern(generatedId, arr[1],arr[2],
//                        sdfo.parse(arr[3]),arr[4], arr[5], arr[6]));
//                case "PartTime" ->employeeList.add(new PartTime(generatedId, arr[1],arr[2],
//                        sdfo.parse(arr[3]),arr[4], arr[5], Integer.parseInt(arr[6])));
//            }
//        }
//        return employeeList;
//    }




//    public static Date inputDate() {
//        while (true) {
//            try {
//                System.out.println("Nhập ngày (dd/MM/yyyy):");
//                String raw = sc.nextLine().trim();
//
//                if (raw.isEmpty()) {
//                    System.out.println(ERROR_VOID);
//                    continue;
//                }
//
//                if (!raw.matches("\\d{2}/\\d{2}/\\d{4}")) {
//                    System.out.println(ERROR_INPUT);
//                    continue;
//                }
//
//                LocalDate.parse(raw, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                return sdf.parse(raw);
//
//            } catch (Exception e) {
//                System.out.println(ERROR_DATE);
//            }
//        }
//
//
//    }

//    public static Date inputFutureDate() {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        sdf.setLenient(false);
//        while (true) {
//            String s = sc.nextLine().trim();
//            try {
//                Date d = sdf.parse(s);
//                if (d.after(new Date())) return d;
//                System.out.println("Nhập sai ngày, nhập lại.");
//            } catch (Exception e) {
//                System.out.println("Ngày không hợp lệ, nhập lại.");
//            }
//        }
//    }


    private static Object convert(String input, Class<?> type) {
        return switch (type.getSimpleName()) {
            case "int", "Integer" -> Integer.parseInt(input);
            case "double", "Double" -> Double.parseDouble(input);
            case "long", "Long" -> Long.parseLong(input);
            case "boolean", "Boolean" -> Boolean.parseBoolean(input);
            default -> input;
        };
    }


    public static <T> void saveState(List<T> list, Stack<List<T>> history) {
        history.push(new ArrayList<>(list));
    }

    public static <T> boolean undo(List<T> list, Stack<List<T>> history) {
        if (history.isEmpty()) return false;
        list.clear();
        list.addAll(history.pop());
        return true;
    }

    public static <T> List<T> findByString(
            List<T> list,
            String keyword,
            Function<T, String> getter
    ) {
        List<T> result = new ArrayList<>();

        for (T item : list) {
            String value = getter.apply(item);
            if (value != null && value.contains(keyword)) { // hoặc .equals(keyword) nếu muốn trùng chính xác
                result.add(item);
            }
        }

        return result;
    }

//    public static String inputDate() {
//        while (true) {
//            try {
//                String temp = inputString("Nhập ngày hết hạn (dd/MM/yyyy): ");
//                UserException.validateDate(temp, 0, 150);
//                return temp;
//            } catch (UserException e) {
//                System.out.println(e.getMessage()); // Báo lỗi
//                System.out.println("Vui lòng nhập lại!\n");
//            }
//        }
//    }


//    public static void main(String[] args) {
//        List<String> items = new ArrayList<>();
//        Stack<List<String>> history = new Stack<>();
//
//        items.add("A");
//        items.add("B");
//        saveState(items, history);
//
//        items.add("C");
//        System.out.println("Sau khi thêm C: " + items);
//
//        boolean undone = undo(items, history);
//        System.out.println("Undo thành công? " + undone);
//        System.out.println("Sau undo: " + items);
//    }


    public static <T> List<T> filterList(List<T> list, Predicate<T> condition) {
        List<T> result = new ArrayList<>();
        if (list == null || condition == null) return result;
        for (T item : list) {
            if (condition.test(item)) result.add(item);
        }
        return result;
    }

    public static void printListPaginated(List<?> list, int pageSize) {
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        int total = list.size();
        int pages = (int) Math.ceil((double) total / pageSize);
        for (int i = 0; i < pages; i++) {
            int start = i * pageSize;
            int end = Math.min(start + pageSize, total);
            System.out.println("Trang " + (i + 1) + "/" + pages + ":");
            for (int j = start; j < end; j++) {
                System.out.println((j + 1) + ". " + list.get(j));
            }
            if (i < pages - 1) {
                System.out.println("Nhấn Enter để xem trang tiếp theo...");
                sc.nextLine();
            }
        }
    }


    public static String readString(String message, List<String> allowedValues) {
        String input;
        while (true) {
            System.out.print(message + " " + allowedValues + ": ");
            input = sc.nextLine().trim();
            if (allowedValues.contains(input)) {
                return input;
            }
            System.out.println("Giá trị không hợp lệ. Vui lòng nhập một trong các giá trị sau: " + allowedValues);
        }
    }

    public static boolean readYesNo(String message) {
        String input;
        while (true) {
            System.out.print(message + " [Y/N]: ");
            input = sc.nextLine().trim().toUpperCase();
            if (input.equals("Y")) return true;
            if (input.equals("N")) return false;
            System.out.println("Giá trị không hợp lệ. Vui lòng nhập Y hoặc N.");
        }
    }

    public static <T> T readOptionByIndex(List<T> options , String mess) {
        System.out.println(mess);
        String input;
        while (true) {
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.print("Nhập lựa chọn: ");
            input = sc.nextLine().trim();
            if (input.matches("\\d")) {
                int index = Integer.parseInt(input);
                if (index >= 1 && index <= options.size()) {
                    return options.get(index - 1);
                } else {
                    System.out.println(ERROR_NUMBER);
                }
            }
        }
    }


    String FILLED;

    public static void showMenu() {
        final Scanner sc = new Scanner(System.in);
        final int ADD = 1;
        final int DISPLAY = 2;
        final int DELETE = 3;
        final int FIND = 4;
        final int PAGE = 5;
        final int EDIT = 6;
        final int FILLED = 7;
        final int CALCULATE = 8;
        final int EXIT = 9;
        while (true) {
            System.out.println("------MENU------");
            System.out.println("""
                    1. Thêm
                    2. Hiển thị
                    3. Xóa
                    4. Tìm
                    5. Hiển thị theo list 3
                    6. Chỉnh sửa
                    7. Lọc
                    8. Tính toán
                    9. Thoát chương trình""");
            System.out.println("-------Nhập vào để lựa chọn ------");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case ADD -> {

                }
                case DISPLAY -> {

                }
                case DELETE -> {

                }
                case FIND -> {

                }
                case PAGE -> {

                }
                case EDIT -> {

                }
                case CALCULATE -> {

                }
                case FILLED -> {

                }
                case EXIT -> {
                    return;
                }

            }
        }

    }

//     while (true) {
//        try {
//            System.out.println("------MENU------");
//            System.out.println("""
//                        1. Add House
//                        2. Add Villa
//                        3. Add Room
//                        4. Return""");
//            System.out.println("-------Nhập vào để lựa chọn ------");
//            int choice = Integer.parseInt(sc.nextLine());
//            switch (choice) {
//                case 1 -> inputHouse();
//                case 2 -> inputVilla();
//                case 3 -> inputRoom();
//                case 4 -> {
//                    return;
//                }
//
//            }
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//    }

//    public static int chooseType() {
//        while (true) {
//            try {
//                System.out.println("------MENU------");
//                System.out.println("""
//                        1. Add Drone
//                        2. Add Car""");
//                System.out.println("-------Nhập vào để lựa chọn ------");
//                int choice = Integer.parseInt(sc.nextLine());
//                if (choice == 1 || choice == 2) {
//                    return choice;
//                } else {
//                    System.out.println("Nhập số hợp lệ");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println(ERROR_INPUT);
//            }
//        }
//    }




    public static class Validator {
        public void validateEmployeeCode(String code) throws UserException {
            if (!Pattern.matches("NV-\\d{4}", code)) {
                throw new UserException("Mã nhân viên không hợp lệ. Định dạng NV-YYYY.");
            }
        }

        public void validateName(String name) throws UserException {
            if (!Pattern.matches("([A-Z][a-z]+\\s?)+", name)) {
                throw new UserException("Tên nhân viên không hợp lệ. Viết hoa chữ cái đầu mỗi từ.");
            }
        }

        public void validateBirthDate(String birthDateStr) throws UserException {
            try {
                LocalDate birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int age = Period.between(birthDate, LocalDate.now()).getYears();
                if (age < 18) {
                    throw new UserException("Nhân viên phải đủ 18 tuổi.");
                }
            } catch (DateTimeParseException e) {
                throw new UserException("Ngày sinh không hợp lệ. Định dạng yyyy-MM-dd.");
            }
        }

        public void validateCMND(String cmnd) throws UserException {
            if (!Pattern.matches("\\d{9}|\\d{12}", cmnd)) {
                throw new UserException("CMND phải đủ 9 hoặc 12 số.");
            }
        }

        public void validatePhone(String phone) throws UserException {
            if (!Pattern.matches("0\\d{9}", phone)) {
                throw new UserException("Số điện thoại phải bắt đầu từ 0 và đủ 10 số.");
            }
        }

        public void validateSalary(double salary) throws UserException {
            if (salary <= 0) {
                throw new UserException("Lương phải lớn hơn 0.");
            }
        }

        public void validateEmail(String email) throws UserException {
            if (!Pattern.matches("\\w+@\\w+(\\.\\w+)+", email)) {
                throw new UserException("Email không hợp lệ. Ví dụ: example@gmail.com");
            }
        }

        public void validateEmail1(String email) throws UserException {
            if (!email.matches(".+@gmail\\.com")) {
                throw new UserException("Email không hợp lệ. Phải có dạng _@gmail.com");
            }
        }

        public static class UserException extends Exception {
            public UserException(String message) {
                super(message);
            }
        }


    }

    public static class EmployeeFileHandler {

        private static final String FILE_PATH = "data/employee.csv";

        public static void saveEmployee(String code, String name, String birthDate, String cmnd,
                                        String phone, double salary, String email) {
            try {
                File dir = new File("data");
                if (!dir.exists()) dir.mkdirs();

                FileWriter writer = new FileWriter(FILE_PATH, true);
                writer.write(String.join(",", code, name, birthDate, cmnd, phone, String.valueOf(salary), email));
                writer.write("\n");
                writer.close();
                System.out.println("Đã lưu nhân viên vào file.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
