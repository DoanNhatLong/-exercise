package view;

import controller.ManagerController;

import java.io.File;

public class RunApp {
    public static void main(String[] args) {
        File item=new File("src/data/player.csv");
        item.setWritable(false);
        ManagerController.showMenu();
    }

}
