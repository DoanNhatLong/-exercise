package repository;

import entity.*;
import ultity.Helper;
import ultity.Library;

import java.util.*;

import static controller.FuramaController.sc;

public class BookingRepository implements IBookingRepository {
    public static TreeSet<Booking> repo = new TreeSet<>(new BookingComparator());
    CustomerRepository customerRepository=new CustomerRepository();

    static {
        repo.add(new Booking("02", "04", null, new Date("11/16/2025"), null, "KH-1212"));
        repo.add(new Booking("14", "01", null, new Date("11/20/2025"), null, "KH-1214"));
        repo.add(new Booking("7", "6", null, new Date("11/1/2025"), null, "KH-1215"));
        repo.add(new Booking("06", "1", null, new Date("11/3/2024"), null, "KH-1216"));
        repo.add(new Booking("7", "7", null, new Date("10/4/2025"), null, "KH-1219"));
        repo.add(new Booking("7", "9", null, new Date("11/11/2025"), null, "KH-1222"));
    }


    @Override
    public void displayBooking() {
        Helper.display(repo);
    }

    @Override
    public void addBooking(Booking item) {
        repo.add(item);
        String temp=item.getIdBooking();
        switch (temp){
            case "House"-> FacilityRepository.increaseValue(new House());
            case "Villa"-> FacilityRepository.increaseValue(new Villa());
            case "Room"-> FacilityRepository.increaseValue(new Room());

        }
    }


    private static class BookingComparator implements Comparator<Booking> {
        @Override
        public int compare(Booking b1, Booking b2) {
            int idB1 = Integer.parseInt(b1.getIdService());
            int idB2 = Integer.parseInt(b2.getIdService());
            if (idB1 != idB2) {
                return Integer.compare(idB1, idB2);
            } else {
                return Integer.compare(Integer.parseInt(b1.getIdBooking()),Integer.parseInt(b2.getIdBooking()));
            }
        }
    }

    public static TreeSet<Booking> getRepo(){
        return repo;
    }

}
