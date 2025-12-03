package controller;

import repository.IProductRepository;
import service.IProductService;
import service.ProductService;
import ultity.Menu;

public class ProductController extends Menu {
    static IProductService productService=new ProductService();

    public static void showMenu(){
        new ProductController().showMenu("Product");
    }

    @Override
    protected void handleDisplay() {
        productService.handleDisplay();
    }

    @Override
    protected void handleAdd() {
        productService.handleAdd();
    }

    @Override
    protected void handleSorter() {
        productService.handleSorter();
    }

    @Override
    protected void handleFilter() {
        productService.handleFilter();
    }

    @Override
    protected void handleDelete() {
        productService.handleDelete();
    }
}
