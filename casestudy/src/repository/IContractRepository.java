package repository;

import entity.Contract;

public interface IContractRepository {
    void createContract();
    void displayContract();
    void editContract(String id);
}
