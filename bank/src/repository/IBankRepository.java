package repository;

import entity.BankBook;

import java.util.List;

public interface IBankRepository {
    void handleAdd(BankBook bankBook);

    void handleDisplay();

    void handleFindByDate(String date);

    void handleSort();

    void handleUpdated(String id);

    void handleFindByType(String type);

    List<BankBook> getAll();
}
