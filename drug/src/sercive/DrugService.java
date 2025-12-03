package sercive;

import entity.Drug;
import repository.DrugRepository;
import repository.IDrugRepository;

import java.text.ParseException;

public class DrugService implements IDrugService {
    IDrugRepository drugRepository = new DrugRepository();

    @Override
    public void displayDrug() throws ParseException {
        drugRepository.displayDrug();

    }

    @Override
    public void addDrug(Drug temp) {
        drugRepository.addDrug(temp);
    }

    @Override
    public void deleteDrug() throws ParseException {
        drugRepository.deleteDrug();

    }

    @Override
    public void updatedDrug(String name) throws ParseException {
        drugRepository.updatedDrug(name);
    }

    @Override
    public void sortDrug() throws ParseException {
        drugRepository.sortDrug();
    }
}
