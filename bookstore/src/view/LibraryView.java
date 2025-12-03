package view;

import entity.Book;
import entity.Magazine;
import service.ILibraryService;
import service.LibraryService;
import ulitity.Helper;
import ulitity.UserException;

import static ulitity.Helper.inputInt;
import static ulitity.Helper.inputString;
import static view.RunApp.ERROR_NUMBER;
import static view.RunApp.sc;

public class LibraryView {
    public static ILibraryService libraryService = new LibraryService();

    public static Book inputBook() {
        int year = inputInt("Nhập năm xuất bản ", 0, 2026);
        String name = inputString("Nhập tên sách");
        String date = inputDate();
        String isbn = inputIsbn();
        String author = inputString("Nhập tác giả");
        return new Book(year, name, date, isbn, author);
    }

    public static Magazine inputMagazine() {
        int year = inputInt("Nhập năm xuất bản ", 0, 2026);
        String name = inputString("Nhập tên sách");
        String date = inputDate();
        String author = inputString("Nhập tác giả");
        int volume = inputVolume();
        return new Magazine(year, name, date, author, volume);
    }

    public static String inputDate() {
        while (true) {
            try {
                String temp = inputString("Nhập ngày xuất bản (dd/MM/yyyy): ");
                UserException.validateDate(temp);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập lại!\n");
            }
        }
    }

    public static int inputVolume() {
        while (true) {
            try {
                int temp = inputInt("Nhập số tập (>0)");
                UserException.validateVolume(temp);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập lại!\n");
            }
        }
    }

    public static String inputIsbn() {
        while (true) {
            try {
                String temp = inputString("Nhập mã isbn");
                ;
                UserException.validateIsbn(temp);
                return temp;
            } catch (UserException e) {
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập lại!\n");
            }
        }
    }

    public static int displaySearch() {
        while (true) {
            System.out.println("------MENU------");
            System.out.println("""
                    1. Tìm theo isbn
                    2. Tìm theo tên
                    3. Tìm theo năm
                    0. Thoát chương trình""");
            System.out.println("-------Nhập vào để lựa chọn ------");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1, 2, 3 -> {
                    return choice;
                }
                case 0 -> {
                    return 0;
                }
                default -> System.out.println(ERROR_NUMBER);

            }
        }
    }
}
