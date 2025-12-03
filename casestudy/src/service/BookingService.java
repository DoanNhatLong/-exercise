package service;

import entity.Booking;
import repository.BookingRepository;
import repository.IBookingRepository;

public class BookingService implements IBookingService {
    private static final IBookingRepository bookingRepository = new BookingRepository();

    @Override
    public void displayBooking() {
        bookingRepository.displayBooking();
    }

    @Override
    public void addBooking(Booking item) {
        bookingRepository.addBooking(item);
    }
}
