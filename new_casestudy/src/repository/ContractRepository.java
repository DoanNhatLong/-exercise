package repository;

import entity.Booking;
import entity.Contract;
import utils.Helper;

import java.util.*;

public class ContractRepository implements IContractRepository {
    static final TreeSet<Booking> temp = BookingRepository.getAll();
    static final Queue<Booking> bookQueue = new LinkedList<>(temp);
    static final List<Contract> repoContract = new ArrayList<>();

    static {
        bookQueue.removeIf(booking ->booking.getIdService().contains("HO"));
    }

    @Override
    public void displayContract() {
        for (Contract contract : repoContract) {
            System.out.println(contract);
        }

    }

    @Override
    public void createContract() {
        System.out.println("Làm hợp đồng cho" + bookQueue.poll());
        String idContract= Helper.inputString("Nhập ID hợp đồng");
        String idBooking= Objects.requireNonNull(bookQueue.poll()).getIdBooking();
        double moneyFirst=Helper.inputDouble("Nhập tiền cọc",0);
        double total=Helper.inputDouble("Nhập tổng tiền ", (int) moneyFirst);
        repoContract.add(new Contract(idContract,idBooking,moneyFirst,total));
    }

    @Override
    public void editContract() {
        String id=Helper.inputString("Nhập ID booking");
        for (Contract contract : repoContract) {
            if (Objects.equals(contract.getIdBooking(), id)) {
                double total=Helper.inputDouble("Nhập tổng tiền", 0);
                contract.setMoneyTotal(total);
            }
        }

    }

}
