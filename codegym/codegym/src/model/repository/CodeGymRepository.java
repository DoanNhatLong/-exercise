package model.repository;

import model.entity.Ministry;
import model.entity.Person;
import model.entity.Student;
import model.entity.Trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CodeGymRepository implements ICodeGymRepository {
    public static final List<Student> studentList = new ArrayList<>();
    public static final List<Trainer> trainerList = new ArrayList<>();
    public static final List<Ministry> ministryList = new ArrayList<>();
    public static final List<ArrayList<? extends Person>> codeGymList = new ArrayList<>();

    static {
        Student s1 = new Student();
        Student s2 = new Student("12", "Vu", 7);
        Student s3 = new Student("13", "Vui", 9);
        Trainer t1 = new Trainer();
        Trainer t2 = new Trainer("23", "Van", 10000, "Java");
        studentList.addAll(List.of(s1, s2, s3));
        trainerList.addAll(List.of(t1,t2));
        codeGymList.add((ArrayList<? extends Person>) studentList);
        codeGymList.add((ArrayList<? extends Person>) trainerList);
        codeGymList.add((ArrayList<? extends Person>) ministryList);
    }

    @Override
    public void addPerson(Person e) {
        if (e instanceof Student) {
            studentList.add((Student) e);
        } else if (e instanceof Trainer) {
            trainerList.add((Trainer) e);
        } else if (e instanceof Ministry) {
            ministryList.add((Ministry) e);
        }
    }

    @Override
    public void displayCodeGym(int index) {
        for (Person person : codeGymList.get(index - 1)) {
            System.out.println(person);
        }
    }

    public List<ArrayList<? extends Person>> getAll() {
        return codeGymList;
    }

    @Override
    public void deletePerson(String name) {
        boolean flag = false;
        for (ArrayList<? extends Person> list : codeGymList) {
            boolean removed = list.removeIf(element -> Objects.equals(element.getName(), name));
            if (removed) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Không tìm thấy");
        }
    }
}
