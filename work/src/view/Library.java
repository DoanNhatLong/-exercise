package view;

import model.entity.Designer;
import model.entity.Developer;
import model.entity.Employee;
import model.entity.Manager;

import java.util.*;
import java.util.function.Predicate;

public class Library {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static class EmployeeRepository {
        static List<Designer> designerList=new ArrayList<>();
        static List<Developer> developerList=new ArrayList<>();
        static List<Manager> managerList=new ArrayList<>();
        static List<ArrayList<?extends Employee>> employeeList=new ArrayList<>();
        static {
            employeeList.add((ArrayList<? extends Employee>) designerList);
            employeeList.add((ArrayList<? extends Employee>) developerList);
            employeeList.add((ArrayList<? extends Employee>) managerList);
        }
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

//    public static void main(String[] args) {
//        class Employee {
//            String id;
//            String name;
//            int age;
//            Employee(String id, String name, int age) { this.id = id; this.name = name; this.age = age; }
//            public String toString() { return name + " (" + age + ")"; }
//        }
//
//        List<Employee> employees = List.of(
//                new Employee("E01", "Alice", 25),
//                new Employee("E02", "Bob", 30),
//                new Employee("E03", "Charlie", 22)
//        );
//
//        List<Employee> filtered = filterList(employees, e -> e.age > 24);
//        System.out.println(filtered);
//    }

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
                SCANNER.nextLine();
            }
        }
    }


//    public static void main(String[] args) {
//        List<String> items = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K");
//        printListPaginated(items, 3);
//    }

    public static String readString(String message, List<String> allowedValues) {
        String input;
        while (true) {
            System.out.print(message + " " + allowedValues + ": ");
            input = SCANNER.nextLine().trim();
            if (allowedValues.contains(input)) {
                return input;
            }
            System.out.println("Giá trị không hợp lệ. Vui lòng nhập một trong các giá trị sau: " + allowedValues);
        }
    }

//    public static void main(String[] args) {
//        List<String> options = List.of("Nam", "Nữ", "Khác");
//        String gender = readString("Chọn giới tính", options);
//        System.out.println("Bạn đã chọn: " + gender);
//    }

    public static boolean readYesNo(String message) {
        String input;
        while (true) {
            System.out.print(message + " [Y/N]: ");
            input =SCANNER.nextLine().trim().toUpperCase();
            if (input.equals("Y")) return true;
            if (input.equals("N")) return false;
            System.out.println("Giá trị không hợp lệ. Vui lòng nhập Y hoặc N.");
        }
    }

//public static void main(String[] args) {
//    boolean confirm = readYesNo("Bạn có muốn tiếp tục không?");
//    System.out.println("Kết quả: " + confirm);
//}

    public static String readOptionByIndex(String message, List<String> options) {
        String input;
        while (true) {
            System.out.println(message);
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.print("Nhập số lựa chọn: ");
            input = SCANNER.nextLine().trim();
            if (input.matches("\\d")) {
                int index = Integer.parseInt(input);
                if (index >= 1 && index <= options.size()) {
                    return options.get(index - 1);
                }
            }
        }
    }

//    public static void main(String[] args) {
//        List<String> brands = List.of("Toyota", "VinFast", "BMW", "Honda");
//        String brand = readOptionByIndex("Chọn hãng xe:", brands);
//        System.out.println("Bạn đã chọn: " + brand);
//    }

    String  DELETEBYID;

//    public static void deleteEmployee(String id) {
//        boolean removed = false;
//        for (ArrayList<? extends Employee> employees : repo.getAll()) {
//            boolean temp = employees.removeIf(element -> Objects.equals(element.getId(), id));
//            if (temp) {
//                removed = true;
//            }
//        }
//        if (removed) {
//            System.out.println("Đã xóa thành công");
//        } else {
//            System.out.println("Không có ID nào trùng");
//        }
//    }

    String FILLED;

//    public static void findByID(String id) {
//        boolean found = false;
//        for (ArrayList<? extends Employee> employees : repo.getAll()) {
//            for (Employee employee : employees) {
//                if (employee.getId().contains(id)) {
//                    System.out.println(employee);
//                    found = true;
//                }
//            }
//        }
//        if (!found) {
//            System.out.println("Không tìm thấy");
//        }
//
//    }

    public static void showMenu(){
        final Scanner sc=new Scanner(System.in);
        final int ADD=1;
        final int DISPLAY=2;
        final int DELETE=3;
        final int FIND=4;
        final int PAGE=5;
        final int EDIT=6;
        final int FILLED=7;
        final int CALCULATE=8;
        final int EXIT=9;
        while (true){
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
            int choice=Integer.parseInt(sc.nextLine());
            switch (choice){
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
                case EXIT-> {
                    return;
                }

            }
        }

    }
}






