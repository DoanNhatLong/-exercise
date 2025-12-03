package repository;

import entity.Product;

import java.util.List;

public interface IProductRepository {
    void handleDisplay();

    void handleAdd();

    void handleSorter();

    void handleFilter();

    void handleDelete();

    List<Product> getAll();
}
