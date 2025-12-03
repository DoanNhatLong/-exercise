package controller;

import model.entity.ChoiceList;
import model.entity.Person;
import model.entity.Trainer;
import model.service.CodeGymService;
import model.ultity.Library;
import view.InputData;

import static controller.CodeGymController.sc;

public class TrainerController {
    public static void showMenu() {
        final int ADD = 1;
        final int DISPLAY = 2;
        final int DELETE = 3;
        final int EXIT = 9;
        while (true) {
            System.out.println("------MENU------");
            System.out.println("""
                    1. Thêm
                    2. Hiển thị
                    3. Xóa
                    4. Sửa điểm
                    9. Về menu chính""");
            System.out.println("-------Nhập vào để lựa chọn ------");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case ADD -> {
                    Person temp = InputData.inputBasic();
                    System.out.println("Nhập ngôn ngữ");
                    String tech= Library.readOptionByIndex( ChoiceList.tech);
                    CodeGymService.repo.addPerson(new Trainer(temp, tech));
                }
                case DISPLAY -> CodeGymService.repo.displayCodeGym(CodeGymController.choiceFirst);

                case DELETE -> {
                    System.out.println("Nhập tên muốn xóa");
                    String temp = sc.nextLine();
                    CodeGymService.repo.deletePerson(temp);
                }
                case EXIT -> {
                    return;
                }
            }

        }

    }
}



