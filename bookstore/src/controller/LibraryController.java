package controller;

import service.ILibraryService;
import service.LibraryService;

import static view.RunApp.ERROR_NUMBER;
import static view.RunApp.sc;

public class LibraryController {
    public static void showMenu(){
        ILibraryService libraryService=new LibraryService();
        final int ADD_BOOK = 1;
        final int ADD_MAGAZINE = 2;
        final int DISPLAY = 3;
        final int ADD_AUTHOR = 4;
        final int DISPlAYY_TOP10 = 5;
        final int SEARCH = 6;
        final int EXIT = 0;
        while (true) {
            System.out.println("------MENU------");
            System.out.println("""
                    1. Thêm sách
                    2. Thêm tạp chí
                    3. Hiển thị
                    4. Thêm tác giả
                    5. Hiển thị top 10
                    6. Tìm kiếm
                    0. Thoát chương trình""");
            System.out.println("-------Nhập vào để lựa chọn ------");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case ADD_BOOK -> libraryService.addBook();
                case ADD_MAGAZINE -> libraryService.addMagazine();
                case DISPLAY -> libraryService.display();
                case ADD_AUTHOR -> libraryService.addAuthor();
                case DISPlAYY_TOP10 -> libraryService.displayTop();
                case SEARCH -> libraryService.search();
                case EXIT -> {
                    return;
                }
                default -> System.out.println(ERROR_NUMBER);
            }
        }
    }
}
