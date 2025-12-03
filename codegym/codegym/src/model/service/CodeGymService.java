package model.service;

import model.entity.Person;
import model.entity.Student;
import model.repository.CodeGymRepository;
import model.repository.ICodeGymRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CodeGymService implements ICodeGymService {
    public static final ICodeGymRepository repo = new CodeGymRepository();

    public static void editScore(String id, double change) {
        boolean flag = false;
        for (Person person : repo.getAll().get(0)) {
            if (Objects.equals(person.getId(), id)) {
                ((Student) person).setScore(change);
                flag = true;
                break;
            }
        }
        System.out.println(flag ? "Đã sửa thành công " : "Không tìm thấy");
    }


    @Override
    public void addPerson(Person e) {
        repo.addPerson(e);
    }

    @Override
    public void displayCodeGym(int index) {
        repo.displayCodeGym(index);
    }

    @Override
    public List<ArrayList<? extends Person>> getAll() {
        return repo.getAll();
    }
}
