package entity;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

import static view.RunApp.formatter;

public class Booking {
    String idBooking;
    String dateBooking;
    String dateStart;
    String dateEnd;
    String idCustomer;
    String idService;

    public Booking() {
    }

    public Booking(String idBooking, String dateBooking, String dateStart, String dateEnd, String idCustomer, String idService) {
        this.idBooking = idBooking;
        this.dateBooking = dateBooking;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.idCustomer = idCustomer;
        this.idService = idService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", dateBooking='" + dateBooking + '\'' +
                ", dateStart='" + dateStart + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", idService='" + idService + '\'' +
                '}';
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public static final Comparator<Booking> BOOKING_COMPARATOR = Comparator
            .comparing((Booking b) -> LocalDate.parse(b.getDateStart(), formatter))
            .thenComparing((Booking b) -> Integer.parseInt(b.getIdBooking()))
            .reversed();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(idBooking, booking.idBooking) && Objects.equals(idCustomer, booking.idCustomer) && Objects.equals(idService, booking.idService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking, idCustomer, idService);
    }
}