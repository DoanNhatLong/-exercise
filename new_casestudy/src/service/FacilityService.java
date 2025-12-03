package service;

import repository.FacilityRepository;
import repository.IFacilityRepository;

public class FacilityService implements IFacilityService {
    IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public void handleAdd() {
        facilityRepository.handleAdd();
    }

    @Override
    public void handleDisplay() {
        facilityRepository.handleDisplay();
    }

    @Override
    public void handleMaintenance() {
        facilityRepository.handleMaintenance();
    }
}
