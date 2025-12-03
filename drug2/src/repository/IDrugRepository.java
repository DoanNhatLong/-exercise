package repository;

import entity.Drug;

import java.util.List;
import java.util.function.Function;

import static repository.DrugRepository.DRUG_LIST;

public interface IDrugRepository extends Repository<Drug> {
    void handleDisplay();

    void handleAdd(Drug temp);

    void handleSorter();

    void handleFilter();

    void handleDelete();

    List<Drug> getAll();

    @Override
    default List<Drug> getAll1(
            String filePath,
            Function<String[], Drug> mapper) {
        return Repository.super.getAll1(DRUG_LIST, mapper);
    }
}
