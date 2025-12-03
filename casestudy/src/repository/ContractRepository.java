package repository;

import entity.Booking;
import entity.Contract;
import ultity.Helper;

import java.util.*;

import static controller.FuramaController.sc;

public class ContractRepository implements IContractRepository {
    static final TreeSet<Booking> temp = BookingRepository.getRepo();
    static final Queue<Booking> bookQueue = new LinkedList<>(temp);
    static final List<Contract> repoContract = new ArrayList<>();

    static {
        bookQueue.removeIf(booking -> Objects.equals(booking.getIdCustomer(), "House"));
    }


    @Override
    public void createContract() {
        String idBooking = Objects.requireNonNull(bookQueue.poll()).getIdBooking();
        System.out.println("Làm contract cho mã" + idBooking);
        System.out.println("Nhập số hợp đồng ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tiền cọc");
        double moneyFirst = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập tiền ");
        double money = Double.parseDouble(sc.nextLine());
        repoContract.add(new Contract(id, idBooking, moneyFirst, money));
    }

    @Override
    public void displayContract() {
        Helper.display(repoContract);
    }

    @Override
    public void editContract(String id) {
        System.out.println("Nhâp idBooking");
        for (Contract contract : repoContract) {
            if (Objects.equals(contract.getIdBooking(), id)) {
                System.out.println("Nhập tổng tiền ");
                double totalMoney=Double.parseDouble(sc.nextLine());
                contract.setTotalMoney(totalMoney);
            }
        }
    }
}
