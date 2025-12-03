package service;

import entity.BankBook;
import repository.BankRepository;
import repository.IBankRepository;
import repository.ListToInput;
import ultity.Helper;
import ultity.Library;
import view.BankView;

import java.util.List;

public class BankService implements IBankService {
    IBankRepository bankRepository = new BankRepository();

    @Override
    public void handleAdd() {
        BankBook temp= BankView.inputBankBook();
        bankRepository.handleAdd(temp);
    }

    @Override
    public void handleDisplay() {
        bankRepository.handleDisplay();
    }

    @Override
    public void handleFindByDate() {
        String date= Helper.inputString("Nhập ngày muốn tìm");
        bankRepository.handleFindByDate(date);
    }

    @Override
    public void handleSort() {
        bankRepository.handleSort();
    }

    @Override
    public void handleUpdated() {
        String id=Helper.inputString("Nhập id muốn cập nhập");
        bankRepository.handleUpdated(id);
    }

    @Override
    public void handleFindByType() {
        String type= Library.readOptionByIndex(ListToInput.type,"Chọn loại muốn tìm");
        bankRepository.handleFindByType(type);
    }

}
