package model.repository;

import model.entity.Person;

import java.util.ArrayList;
import java.util.List;

public interface ICodeGymRepository {
    void addPerson(Person e);
    void displayCodeGym(int index);
    List<ArrayList<? extends Person>> getAll();
    void deletePerson(String name);
}
