package service;

import entity.Drug;
import repository.DrugRepository;
import repository.IDrugRepository;
import view.DrugView;

public class DrugService implements IDrugService {
    IDrugRepository drugRepository = new DrugRepository();

    @Override
    public void handleDisplay() {
        drugRepository.handleDisplay();
    }

    @Override
    public void handleAdd() {
        Drug temp= DrugView.inputDrug();
        drugRepository.handleAdd(temp);
    }

    @Override
    public void handleSorter() {
        drugRepository.handleSorter();

    }

    @Override
    public void handleFilter() {
        drugRepository.handleFilter();
    }

    @Override
    public void handleDelete() {
        drugRepository.handleDelete();
    }
}
