package repository;

import entity.Drug;
import ultity.Helper;
import ultity.Library;
import ultity.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class DrugRepository implements IDrugRepository {
    public static final String DRUG_LIST = "src/data/drug.csv";

    @Override
    public void handleDisplay() {
        for (Drug drug : getAll()) {
            System.out.println(drug);
        }
    }

    @Override
    public void handleAdd(Drug temp) {
        List<String> stringList = new ArrayList<>();
        stringList.add(temp.toCSV());
        ReadAndWriteFile.write(DRUG_LIST, stringList, true);
    }

    @Override
    public void handleSorter() {
        List<Drug> drugList = getAll();
        drugList.sort(Comparator
                .comparing((Drug b) -> b.getInput()));
        for (Drug drug : drugList) {
            System.out.println(drug);
        }
    }

    @Override
    public void handleFilter() {
        String temp= Helper.inputString("Nhập id muốn tìm");
        List<Drug> list= Library.findByCondition(
                getAll(),
                temp,
                Drug::getId);
        System.out.println(!list.isEmpty()?"Kết quả tỉm kiếm":"Không có id trùng");
    }

    @Override
    public void handleDelete() {
        String temp= Helper.inputString("Nhập id muốn tìm");
        boolean flag=Library.handleDelete(
                getAll(),
                drug-> Objects.equals(drug.getId(), temp),
                Drug::toCSV,
                DRUG_LIST
        );
        System.out.println(flag?"Xóa thành công":"Không có id trùng");

    }

    @Override
    public List<Drug> getAll() {
        return Library.getAll(
                DRUG_LIST,
                arr -> new Drug(arr[0], arr[1], arr[2]
                        , Integer.parseInt(arr[3]), Integer.parseInt(arr[4]))
        );
    }
}
