package repository;

import entity.Facility;
import entity.House;
import entity.Room;
import entity.Villa;
import view.FacilityView;

import java.util.*;

public class FacilityRepository implements IFacilityRepository {
    private final static LinkedHashMap<Facility, Integer> repo = new LinkedHashMap<>();

    static {
        repo.put(new House("HO-1111"), 4);
        repo.put(new Villa("VL-3333"), 6);
        repo.put(new Room("RO-2222"), 3);
    }
    @Override
    public void handleAdd() {
        Facility temp= FacilityView.inputFacility();
        repo.put(temp,1);
    }

    @Override
    public void handleDisplay() {
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : repo.entrySet()) {
            System.out.println(facilityIntegerEntry);
        }
    }

    @Override
    public void handleMaintenance() {
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : repo.entrySet()) {
            if (facilityIntegerEntry.getValue()>=5){
                System.out.println(facilityIntegerEntry.getKey());
            }
        }
    }

    @Override
    public List<Facility> getAll() {
        return new ArrayList<>(repo.keySet());
    }

    public static void increase(String idService) {
        boolean flag=true;
        for (Facility facility : repo.keySet()) {
            if (Objects.equals(facility.getIdService(), idService)){
                repo.put(facility,repo.get(facility)+1);
                flag=false;
                break;
            }
        }
        if (flag){
            repo.put(new House(idService),1);
        }
    }

}
