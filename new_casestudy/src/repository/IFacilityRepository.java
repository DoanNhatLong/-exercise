package repository;

import entity.Facility;

import java.util.List;

public interface IFacilityRepository {
    void handleAdd();

    void handleDisplay();

    void handleMaintenance();

    List<Facility> getAll();
}
