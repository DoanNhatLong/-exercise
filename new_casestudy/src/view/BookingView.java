package view;

import entity.Booking;
import entity.Customer;
import entity.Facility;
import repository.CustomerRepository;
import repository.FacilityRepository;
import repository.IFacilityRepository;
import utils.Helper;
import utils.Library;
import utils.UserException;

import java.time.LocalDate;
import java.util.List;

import static view.RunApp.formatter;
import static view.RunApp.sc;

public class BookingView {
    public static Booking inputBooking() {
        String idBooking = Helper.inputString("Nhập ID booking");
        String dateBooking = inputDateBooking();
        LocalDate tempDate = LocalDate.parse(dateBooking, formatter);
        String dateStart = inputDateStart(tempDate);
        String dateEnd = inputDateEnd();
        String idCustomer= chooseCustomer().getIdCustomer();
        String idService= chooseFacility().getIdService();
        return new Booking(idBooking,dateBooking,dateStart,dateEnd,idCustomer,idService);
    }

    public static String inputDateBooking() {
        return Library.inputData(
                () -> Helper.inputString("Nhập vào ngày đặt ( dd/MM/yyyy)"),
                (String temp) -> UserException.validateDate(temp, 0, 100)
        );
    }

    public static String inputDateStart(LocalDate tempDate) {
        while (true) {
            String date = Library.inputData(
                    () -> Helper.inputString("Nhập vào ngày bắt đầu ( dd/MM/yyyy)"),
                    (String temp) -> UserException.validateDate(temp, 0, 100)
            );
            if (LocalDate.parse(date, formatter).isBefore(tempDate)) {
                System.out.println("Ngày bắt đầu phải sau ngày đặt ");
            } else return date;
        }
    }

    public static String inputDateEnd() {
        return Library.inputData(
                () -> Helper.inputString("Nhập vào ngày kết thúc ( dd/MM/yyyy)"),
                UserException::validateFutureDate
        );
    }

    public static Customer chooseCustomer() {
        CustomerRepository customerRepository = new CustomerRepository();
        var list = customerRepository.getAll();
        while (true) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
            System.out.print("Nhập lựa chọn: ");
            String input = sc.nextLine().trim();
            if (input.matches("\\d")) {
                int index = Integer.parseInt(input);
                if (index >= 1 && index <= list.size()) {
                    return list.get(index - 1);
                }
            }
        }

    }

    public static Facility chooseFacility(){
        IFacilityRepository facilityRepository=new FacilityRepository();
        List<Facility> list = facilityRepository.getAll();
        while (true) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
            System.out.print("Nhập lựa chọn: ");
            String input = sc.nextLine().trim();
            if (input.matches("\\d")) {
                int index = Integer.parseInt(input);
                if (index >= 1 && index <= list.size()) {
                    return list.get(index - 1);
                }
            }
        }
    }
}

