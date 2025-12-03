package model.service;

import model.entity.Person;

import java.util.ArrayList;
import java.util.List;

public interface ICodeGymService {
    void addPerson(Person e);
    void displayCodeGym(int index);
    List<ArrayList<? extends Person>> getAll();
}
