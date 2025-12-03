package service;

import entity.Person;

import java.util.List;

public interface Service <T extends Person> {
    void display();
    void addPerson();
    void edit();
    List<T> getAll();
}
