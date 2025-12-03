package controller;

import entity.Facility;
import service.FacilityService;
import service.IFacilityService;
import view.FuramaView;
import static controller.FuramaController.sc;

public class FacilityManagement   {
    private final static IFacilityService<Facility> facilityService=new FacilityService();
    static final int DISPLAY = 1;
    static final int ADD = 2;
    static final int MAINTENANCE = 3;
    static final int RETURN = 4;
    public static void showMenu() throws Exception {
        while (true) {
            try {
                System.out.println("------MENU------");
                System.out.println("""
                        1. Display Facility
                        2. Add Facility
                        3. Display maintenance
                        4. Return""");
                System.out.println("-------Nhập vào để lựa chọn ------");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case DISPLAY -> facilityService.display();
                    case ADD -> facilityService.addFacility(FuramaView.inputFacility());
                    case MAINTENANCE -> facilityService.displayMaintenance();
                    case RETURN -> {
                        return;
                    }

                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

    }
}
