package repository;

import entity.BankBook;
import ultity.Helper;
import ultity.ReadAndWriteFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static view.RunApp.formatter;
import static view.RunApp.sdf;

public class BankRepository implements IBankRepository {
    static final String BANKBOOK_LIST = "src/data/bankbook.csv";


    @Override
    public void handleAdd(BankBook bankBook) {
        List<String> stringList = new ArrayList<>();
        stringList.add(bankBook.toCSV());
        ReadAndWriteFile.write(BANKBOOK_LIST, stringList, true);

    }

    @Override
    public void handleDisplay() {
        for (BankBook bankBook : getAll()) {
            System.out.println(bankBook);
        }
    }

    @Override
    public void handleFindByDate(String date) {
        LocalDate dateFind = LocalDate.parse(date, formatter);
        List<BankBook> bankList = getAll();
        for (BankBook bankBook : bankList) {
            if (LocalDate.parse(bankBook.getDate(), formatter).isBefore(dateFind)) {
                System.out.println(bankBook);
            }
        }
    }

    @Override
    public void handleSort() {
        List<BankBook> bankList = getAll();
        bankList.sort(Comparator
                .comparing((BankBook b) -> LocalDate.parse(b.getDate(), formatter))
                .thenComparing(BankBook::getMoneyInput)
                .reversed()
        );
        for (BankBook bankBook : bankList) {
            System.out.println(bankBook);
        }
    }

    @Override
    public void handleUpdated(String id) {
        List<BankBook> bankList = getAll();
        boolean flag = false;
        for (BankBook bankBook : bankList) {
            if (Objects.equals(bankBook.getId(), id)) {
                String money = Helper.inputString("Nhập số tiền muốn sửa");
                bankBook.setMoneyInput(Float.parseFloat(money));
                flag = true;
                break;
            }
        }
        System.out.println(flag ? "Cập nhập thành công" : "Khong có ID trùng");
        List<String> stringList = new ArrayList<>();
        for (BankBook bankBook : bankList) {
            stringList.add(bankBook.toCSV());
        }
        ReadAndWriteFile.write(BANKBOOK_LIST, stringList, false);
    }

    @Override
    public void handleFindByType(String type) {
        List<BankBook> bankBookList = getAll();
        boolean flag = false;
        for (BankBook bankBook : bankBookList) {
            if (Objects.equals(bankBook.getType(), type)) {
                System.out.println(bankBook);
                flag = true;
            }
        }
        System.out.println(flag ? "Kết quả tìm kiếm" : "Không có kết quả khớp");
    }

    @Override
    public List<BankBook> getAll() {
        List<String> stringList = ReadAndWriteFile.readFileCSVToStringList(BANKBOOK_LIST);
        List<BankBook> bankList = new ArrayList<>();
        for (String string : stringList) {
            String[] arr = string.split(",");
            bankList.add(new BankBook(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], Float.parseFloat(arr[6])
                    , arr[7], Integer.parseInt(arr[8])));
        }
        return bankList;
    }
}
