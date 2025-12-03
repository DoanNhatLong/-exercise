package view;

import model.entity.Person;

import static controller.CodeGymController.sc;

public class InputData {
    public static Person inputBasic(){
        System.out.println("Nhập ID");
        String id=sc.nextLine();
        System.out.println("Nhập name");
        String name=sc.nextLine();
        return new Person(id,name);
    }
}
