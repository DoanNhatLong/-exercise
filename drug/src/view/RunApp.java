package view;

import controller.DrugController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class RunApp {
    public static final Scanner sc=new Scanner(System.in);
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat sdfo = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

    public static void main(String[] args) throws ParseException {
        DrugController.showMenu();
    }
}
