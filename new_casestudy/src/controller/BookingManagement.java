package controller;

import service.BookingService;
import service.ContractService;
import service.IBookingService;
import service.IContractService;
import static view.RunApp.ERROR_NUMBER;
import static view.RunApp.sc;

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
                        case ADD_BOOKING -> bookingService.addBooking();
                        case DISPLAY_CONTRACT -> contractService.displayContract();
                        case ADD_CONTRACT -> contractService.createContract();
                        case EDIT_CONTRACT -> {
                            System.out.println("Nhập ID");
                            contractService.editContract();
                        }
                        case RETURN -> {
                            return;
                        }
                        default -> System.out.println(ERROR_NUMBER);

                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            }

        }

    }

