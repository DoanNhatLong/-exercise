package repository;

import entity.Booking;
import entity.Customer;

public interface IBookingRepository {
    void displayBooking();
    void addBooking(Booking item);
}
