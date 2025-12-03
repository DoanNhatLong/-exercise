package repository;

import entity.Drug;
import ultity.Helper;
import ultity.ReadAndWriteFile;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static view.RunApp.sdfo;

public class DrugRepository implements IDrugRepository {
    public static final String DRUG_LIST = "src/data/drug.csv";

    @Override
    public void displayDrug() throws ParseException {
        for (Drug drug : getAll()) {
            System.out.println(drug);
        }
    }

    @Override
    public void addDrug(Drug temp) {
        List<String> stringList = new ArrayList<>();
        stringList.add(temp.toCSV());
        ReadAndWriteFile.write(DRUG_LIST, stringList, true);
    }

    @Override
    public void deleteDrug() throws ParseException {
        Date now = new Date();
        List<Drug> drugList = getAll();
        boolean flag = drugList.removeIf(drug -> drug.getDate().before(now));
        for (Drug drug : drugList) {
            System.out.println(drug);
        }
        System.out.println(flag?"Đã xóa thành công":"Không có thuốc nào hết hạn");
    }

    @Override
    public void updatedDrug(String name) throws ParseException {
        List<Drug> drugList = getAll();
        boolean flag = false;
        for (Drug drug : drugList) {
            if (Objects.equals(drug.getName(), name)) {
                int output = Helper.inputInt("Nhập số lượng bán ra", 0, drug.getInput());
                drug.setOutput(output);
                flag = true;
                break;
            }
        }
        System.out.println(flag ? "Đã cập nhập" : "Không có tên trùng");
        List<String> stringList = new ArrayList<>();
        for (Drug drug : drugList) {
            stringList.add(drug.toCSV());
        }
        ReadAndWriteFile.write(DRUG_LIST, stringList, false);
    }

    @Override
    public void sortDrug() throws ParseException {
        List<Drug> drugList = getAll();
        drugList.stream()
                .sorted((d1,d2)-> d1.getInput()-d2.getInput())
                .forEach(System.out::println);
    }

    @Override
    public List<Drug> getAll() throws ParseException {
        List<String> stringList = ReadAndWriteFile.readFileCSVToStringList(DRUG_LIST);
        List<Drug> drugList = new ArrayList<>();
        for (String string : stringList) {
            String[] arr = string.split(",");
            drugList.add(new Drug(arr[0], arr[1], sdfo.parse(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4])));
        }
        return drugList;
    }
}
