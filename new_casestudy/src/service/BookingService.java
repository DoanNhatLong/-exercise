package service;

import repository.BookingRepository;
import repository.IBookingRepository;

public class BookingService implements IBookingService {
    IBookingRepository bookingRepository = new BookingRepository();

    @Override
    public void displayBooking() {
        bookingRepository.displayBooking();

    }

    @Override
    public void addBooking() {
        bookingRepository.addBooking();
    }
}
