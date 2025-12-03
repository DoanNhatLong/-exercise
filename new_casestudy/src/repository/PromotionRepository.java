package repository;

import entity.Booking;
import entity.Customer;
import utils.Helper;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.Stack;
import java.util.TreeSet;

import static view.RunApp.formatter;

public class PromotionRepository implements IPromotionRepository {
    TreeSet<Customer> customerTreeSet = new TreeSet<>(new PromotionCompare());

    @Override
    public void displayUseService() {
        int year = Helper.inputInt("Nhập vào năm", 0);
        for (Booking booking : BookingRepository.getAll()) {
            if (LocalDate.parse(booking.getDateStart(), formatter).getYear() == year) {
                System.out.println(booking.getIdCustomer());
            }
        }
    }

    @Override
    public void displayGetVoucher() {
        int fifty = Helper.inputInt("Nhập lượng voucher 50%", 0);
        int twenty = Helper.inputInt("Nhập lượng voucher 20%", 0);
        int ten = Helper.inputInt("Nhập lượng voucher 10%", 0);
        LocalDate now = LocalDate.now();
        Stack<Booking> bookingList = new Stack<>();
        int month = now.getMonthValue();
        int year = now.getYear();
        for (Booking booking : BookingRepository.getAll()) {
            if (LocalDate.parse(booking.getDateStart(), formatter).getYear() == year
                    && LocalDate.parse(booking.getDateStart(), formatter).getMonthValue() == month) {
                bookingList.push(booking);
            }
        }
        int count = 0;
        System.out.println(bookingList.size());
        while (!bookingList.isEmpty()) {
            Booking customer = bookingList.pop();
            count++;
            if (count <= fifty) {
                System.out.println("Khách hàng" + customer.getIdBooking() + "Nhận voucher 50%");
            } else if (count <= fifty + twenty) {
                System.out.println("Khách hàng" + customer.getIdBooking() + "Nhận voucher 20%");
            } else if (count <= ten + fifty + twenty) {
                System.out.println("Khách hàng" + customer.getIdBooking() + "Nhận voucher 10%");
            }
        }

    }

    private static class PromotionCompare implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            int id1 = Integer.parseInt(o1.getIdCustomer());
            int id2 = Integer.parseInt(o2.getIdCustomer());
            return Integer.compare(id1, id2);
        }
    }
}
