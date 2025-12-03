package service;

import entity.Facility;
import repository.FacilityRepository;
import repository.IFacilityRepository;

public class FacilityService implements IFacilityService<Facility> {
    private static final IFacilityRepository<Facility> repoFacility =new FacilityRepository();

    @Override
    public void addFacility(Facility item) {
        repoFacility.addFacility(item);
    }

    @Override
    public void display() {
        repoFacility.display();

    }

    @Override
    public void displayMaintenance() {
        repoFacility.displayMaintenance();
    }
}
