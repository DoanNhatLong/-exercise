package repository;

import java.util.List;

public interface  Repository <T> {
    void handleAdd();

    void handleDisplay();

    void handleEdit();

    List<T> getAll();


}
