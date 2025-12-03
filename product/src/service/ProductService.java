package service;

import repository.IProductRepository;
import repository.ProductRepository;

public class ProductService implements IProductService {
    IProductRepository productRepository = new ProductRepository();

    @Override
    public void handleDisplay() {
        productRepository.handleDisplay();
    }

    @Override
    public void handleAdd() {
        productRepository.handleAdd();

    }

    @Override
    public void handleSorter() {
        productRepository.handleSorter();
    }

    @Override
    public void handleFilter() {
        productRepository.handleFilter();
    }

    @Override
    public void handleDelete() {
        productRepository.handleDelete();
    }
}
