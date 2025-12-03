package service;

import repository.ContractRepository;
import repository.IContractRepository;

public class ContractService implements IContractService{
    IContractRepository contractRepository=new ContractRepository();

    @Override
    public void createContract() {
        contractRepository.createContract();

    }

    @Override
    public void displayContract() {
        contractRepository.displayContract();

    }

    @Override
    public void editContract(String id) {
        contractRepository.editContract(id);
    }
}
