package service;

import entity.BankBook;

import java.util.List;

public interface IBankService {
    void handleAdd();

    void handleDisplay();

    void handleFindByDate();

    void handleSort();

    void handleUpdated();

    void handleFindByType();


}
