package repository;

import entity.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository<Facility> {
    private final static LinkedHashMap<Facility, Integer> repo = new LinkedHashMap<>();

    static {
        repo.put(new House(), 4);
        repo.put(new Villa(), 6);
        repo.put(new Room(), 3);
    }

    public static LinkedHashMap<Facility, Integer> getRepo() {
        return repo;
    }

    @Override
    public void addFacility(Facility item) {
        repo.put(item, 0);
    }

    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> temp : repo.entrySet()) {
            System.out.println(temp.getKey().toString() + ":" + temp.getValue().toString());
        }
    }

    @Override
    public void displayMaintenance() {
        for (Map.Entry<Facility, Integer> integerEntry : repo.entrySet()) {
            if (integerEntry.getValue() >= 5) {
                System.out.println(integerEntry.getKey());
            }
        }
    }

    public static void increaseValue(Facility temp) {
        for (Facility facility : repo.keySet()) {
            if (temp instanceof House && facility instanceof House
                    || temp instanceof Villa && facility instanceof Villa
                    || temp instanceof Room && facility instanceof Room) {
                Integer value = repo.get(facility);
                repo.put(facility, value + 1);
            }
        }
    }
}

