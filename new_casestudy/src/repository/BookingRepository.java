package repository;

import entity.Booking;
import view.BookingView;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;

import static entity.Booking.BOOKING_COMPARATOR;
import static view.RunApp.formatter;

public class BookingRepository implements IBookingRepository {
    public static TreeSet<Booking> repo = new TreeSet<>(BOOKING_COMPARATOR);

    static {
        repo.add(new Booking("02", "04", "11/12/2025", "11/6/2025", "KH-1111", "HO-1212"));
        repo.add(new Booking("14", "01", "6/6/2024", "11/2/2026", null, "KH-1214"));
        repo.add(new Booking("7", "6", "7/12/2025", "11/1/2027", null, "HO-1215"));
        repo.add(new Booking("16", "1", "6/12/2025", "11/3/2026", "KH-1231", "KH-1216"));
        repo.add(new Booking("8", "7", "8/8/2013", "10/4/2026", null, "KH-1219"));
        repo.add(new Booking("9", "9", "8/8/2013", "11/11/2027", null, "KH-1222"));
    }

    @Override
    public void displayBooking() {
        for (Booking booking : repo) {
            System.out.println(booking);
        }
    }

    @Override
    public void addBooking() {
        Booking temp= BookingView.inputBooking();
        repo.add(temp);
        FacilityRepository.increase(temp.getIdService());
    }

    public static TreeSet<Booking> getAll(){
        return repo;
    }

}
