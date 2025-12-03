package sercive;

import entity.Drug;

import java.text.ParseException;
import java.util.List;

public interface IDrugService {
    void displayDrug() throws ParseException;
    void addDrug(Drug temp);
    void deleteDrug() throws ParseException;
    void updatedDrug(String name) throws ParseException;
    void sortDrug() throws ParseException;
}
