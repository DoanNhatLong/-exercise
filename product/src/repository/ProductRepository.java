package repository;

import entity.Electric;
import entity.Food;
import entity.HouseHold;
import entity.Product;
import ultity.Helper;
import ultity.Library;
import ultity.ReadAndWriteFile;
import view.ProductView;

import java.util.*;

public class ProductRepository implements IProductRepository {
    public static final String PRODUCT_LIST = "src/data/product.csv";


    @Override
    public void handleDisplay() {
        for (Product product : getAll()) {
            System.out.println(product);
        }
    }

    @Override
    public void handleAdd() {
        Product temp = ProductView.inputProduct();
        List<String> stringList = new ArrayList<>();
        stringList.add(temp.toCSV());
        ReadAndWriteFile.write(PRODUCT_LIST, stringList, true);

    }

    @Override
    public void handleSorter() {
        List<Product> productList=getAll();
        productList.sort(Comparator
                .comparing((Product product) -> product.getQuantity())
                .reversed());
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Override
    public void handleFilter() {
        String temp= Helper.inputString("Nhập tên muốn tìm");
        Library.findByCondition(
                getAll(),
                temp,
                product->product.getName()
        );
    }

    @Override
    public void handleDelete() {
        String temp= Helper.inputString("Nhập id muốn xóa");
        boolean flag= Library.handleDelete(
                getAll(),
                product -> Objects.equals(product.getIdProduct(), temp),
                Product::toCSV,
                PRODUCT_LIST
        );
        System.out.println(flag?"Đã xóa thành công":"Không tìm thấy ID");
    }

    @Override
    public List<Product> getAll() {
        return Library.getAll(
                PRODUCT_LIST,
                Map.of(
                        "Food", arr -> new Food(arr[1], arr[2], Integer.parseInt(arr[3]), arr[4], arr[5]),
                        "Electric", arr -> new Electric(arr[1], arr[2], Integer.parseInt(arr[3]), arr[4], Integer.parseInt(arr[5])),
                        "HouseHold", arr -> new HouseHold(arr[1], arr[2], Integer.parseInt(arr[3]), arr[4], arr[5])
                )
        );
    }
}
