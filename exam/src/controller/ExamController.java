package controller;

import service.ExamService;
import service.IExamService;

import static view.RunApp.sc;

public class ExamController {
    static IExamService examService = new ExamService();

    public static void showMenu() {
        final int ADD = 1;
        final int DISPLAY = 2;
        final int EXIT = 3;
        while (true) {
            System.out.println("------Quản lý câu hỏi----");
            System.out.println("Chọn chức năng");
            System.out.println("""
                    1. Thêm câu hỏi và đáp án
                    2. Hiển thị danh sách câu hỏi
                    3. Thoát""");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case ADD -> examService.handleAdd();
                case DISPLAY -> examService.handleDisplay();
                case EXIT -> {
                    return;
                }
            }
        }
    }
}
