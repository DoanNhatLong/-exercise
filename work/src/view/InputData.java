package view;

import model.entity.Designer;
import model.entity.Developer;
import model.entity.Employee;
import model.entity.Manager;
import model.repository.ListRepository;

import java.util.List;

import static controller.EmployeeController.sc;

public class InputData {
    public static int inputChoice() {
        int choice;
        while (true) {
            System.out.println("""
                    1. Designer
                    2. Developer
                    3. Manager
                    4. Trở về menu chính""");
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 1 || choice == 2 || choice == 3) {
                return choice;
            } else if (choice == 4) {
                return 0;
            }
        }
    }

    public static Employee inputEmployee() {
        int choice = inputChoice();
        if (choice != 0) {
            while (true) {
                System.out.println("Nhập ID");
                String id = sc.nextLine();
                System.out.println("Nhập name");
                String name = sc.nextLine();
                System.out.println("Nhập năm");
                int year = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập vị trí");
                String position = sc.nextLine();
                System.out.println("Nhập lương");
                double salary = Double.parseDouble(sc.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.println("Nhập chương trình của bạn ");
                        String app= Library.readOptionByIndex("Chọn ", ListRepository.programing);
                        return new Designer(id,name,year,position,salary,app);
                    }
                    case 2 ->{
                        System.out.println("Nhập phần mềm của bạn ");
                        String temp= Library.readOptionByIndex("Chọn ", ListRepository.app);
                        return new Developer(id,name,year,position,salary,temp);
                    }
                    case 3 ->{
                        System.out.println("Nhập kỹ năng của bạn ");
                        String temp= Library.readOptionByIndex("Chọn ", ListRepository.skill);
                        return new Manager(id,name,year,position,salary,temp);
                    }
                }
            }
        }
        return null;
    }
}
