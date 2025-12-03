package repository;

import entity.Booking;
import entity.Customer;

import java.util.*;

public class PromotionRepository implements IPromotionRepository {
    TreeSet<Customer> customerTreeSet = new TreeSet<>(new PromotionCompare());

    @Override
    public void displayUseService(int year) {
        for (Booking booking : BookingRepository.getRepo()) {
            if (booking.getStartBooking().getYear() + 1900 == year) {
                System.out.println(booking);
            }
        }
    }




    @Override
    public void displayGetVoucher(int ten, int twenty, int fifty) {
        Date now = new Date();
        Stack<Booking> bookingList = new Stack<>();
        int month = now.getMonth();
        int year = now.getYear();
        for (Booking booking : BookingRepository.getRepo()) {
            if (booking.getStartBooking().getYear() == year
                    && booking.getStartBooking().getMonth() == month) {
                bookingList.push(booking);
            }
        }
        int count = 0;
        System.out.println(bookingList.size());
        while (!bookingList.isEmpty()) {
            Booking customer = bookingList.pop();
            count++;
            if (count <= fifty) {
                System.out.println(customer.getIdBooking() + "Nhận voucher 50%");
            } else if (count <= fifty + twenty) {
                System.out.println(customer.getIdBooking() + "Nhận voucher 20%");
            } else if (count <= ten + fifty + twenty) {
                System.out.println(customer.getIdBooking() + "Nhận voucher 10%");
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

