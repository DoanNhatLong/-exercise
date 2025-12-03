package controller;

import service.DrugService;
import service.IDrugService;
import ultity.Menu;

public class DrugController extends Menu {
    IDrugService drugService=new DrugService();
    public static void showMenu(){
        new DrugController().showMenu("Drug");
    }

    @Override
    protected void handleDisplay() {
        drugService.handleDisplay();
    }

    @Override
    protected void handleAdd() {
        drugService.handleAdd();
    }

    @Override
    protected void handleSorter() {
        drugService.handleSorter();
    }

    @Override
    protected void handleFilter() {
        drugService.handleFilter();
    }

    @Override
    protected void handleDelete() {
        drugService.handleDelete();
    }
}
