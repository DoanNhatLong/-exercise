package entity;

import java.util.Date;
import java.util.Objects;

public class Booking {
    String idService;
    String idBooking;
    Date date;
    Date startBooking;
    Date endBooking;
    String idCustomer;

    public Booking() {
    }

    public Booking(String idService, String idBooking, Date date, Date startBooking, Date endBooking, String idCustomer) {
        this.idService = idService;
        this.idBooking = idBooking;
        this.date = date;
        this.startBooking = startBooking;
        this.endBooking = endBooking;
        this.idCustomer = idCustomer;
    }

    public Date getDate() {
        return date;
    }

    public Date getStartBooking() {
        return startBooking;
    }

    public Date getEndBooking() {
        return endBooking;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public void setStartBooking(Date startBooking) {
        this.startBooking = startBooking;
    }



    public void setEndBooking(Date endBooking) {
        this.endBooking = endBooking;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idService='" + idService + '\'' +
                ", idBooking='" + idBooking + '\'' +
                ", date=" + date +
                ", startBooking=" + startBooking +
                ", endBooking=" + endBooking +
                ", idCustomer='" + idCustomer + '\'' +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(idService, booking.idService);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idService);
    }
}
