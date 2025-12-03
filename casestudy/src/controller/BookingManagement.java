package controller;

import entity.Booking;
import service.BookingService;
import service.ContractService;
import service.IBookingService;
import service.IContractService;
import view.FuramaView;

import static controller.FuramaController.sc;

public class BookingManagement {
    static final IBookingService bookingService=new BookingService();
    static IContractService contractService=new ContractService();
    static final int DISPLAY_BOOKING= 1;
    static final int ADD_BOOKING = 2;
    static final int DISPLAY_CONTRACT = 3;
    static final int ADD_CONTRACT = 4;
    static final int EDIT_CONTRACT = 5;
    static final int RETURN = 6;

    public static void showMenu() {
        while (true) {
            try {
                System.out.println("------MENU------");
                System.out.println("""
                        1. Display booking
                        2. Add Booking
                        3. Display contract
                        4. Add contract
                        5. Edit contract
                        6. Return""");
                System.out.println("-------Nhập vào để lựa chọn ------");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case DISPLAY_BOOKING -> bookingService.displayBooking();
                    case ADD_BOOKING -> bookingService.addBooking(FuramaView.inputBooking());
                    case DISPLAY_CONTRACT -> contractService.displayContract();
                    case ADD_CONTRACT -> contractService.createContract();
                    case EDIT_CONTRACT -> {
                        System.out.println("Nhập ID");
                        contractService.editContract(sc.nextLine());
                    }
                    case RETURN -> {
                        return;
                    }

                }
            } catch (Exception e) {
                e.getMessage();
            }
        }

    }

}
