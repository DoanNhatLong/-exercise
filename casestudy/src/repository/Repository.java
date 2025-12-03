package repository;
import entity.Person;
import java.util.List;

public interface Repository<T> {
    void display();
    void addPerson(T temp);
    void edit(String id, T temp);
    List<T> getAll();
}
