package repository;

import entity.Facility;

public interface IFacilityRepository <T> {
    void addFacility(T item);
    void display();
    void displayMaintenance();


}
