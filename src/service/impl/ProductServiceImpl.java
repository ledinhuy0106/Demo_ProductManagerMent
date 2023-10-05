package service.impl;
import model.Category;
import model.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static controller.ProductController.*;

public class ProductServiceImpl implements ProductService {
    @Override
    public void add() {
        Product product = new Product();
        product.input();
        save(product);
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void getAll() {
        for (Product product : productList) {
            product.getProduct();
        }
    }

    @Override
    public void update() {
        System.out.println("Nhập vào id sản phẩm cần sửa: ");
        int id = Integer.parseInt(sc.nextLine());
        Product product= productService.getById(id);
        int listindex= productList.indexOf(product);
        Product product1=new Product();
        if (product!=null){
            product1.setId(product.getId());
            product1.inputUpdate();
           productList.set(listindex,product1);
        }else {
            System.out.println("null");
        }
    }

    @Override
    public void delete() {
        getAll();
        System.out.println("Nhập vào id sản phẩm cần xóa: ");
        int idDelete = Integer.parseInt(sc.nextLine());
        Product product = getById(idDelete);
        if (product != null) {
            productList.remove(product);
        } else {
            System.err.println("Sản phẩm không tồn tại!!");
        }

    }

    @Override
    public Product getById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            } else {
                System.err.println("Sản phẩm không tồn tại!!");
            }
        }
        return null;
    }

    @Override
    public List<Product> getProductByCategoryId(int id) {
        List<Product> productList1 = new ArrayList<>();
        for (Product product : productList) {
            if (product.getCategoryId() == id) {
                productList1.add(product);
            } else {
                System.err.println("Sản phẩm không tồn tại!!");
            }
        }
        return productList1;
    }
    public void getProductByCategory(int id) {
        for (Product product : productList) {
            if (product.getCategoryId() == id) {
                product.getProduct();
            } else {
                System.err.println("không tồn tại!!");
            }
        }
    }
    @Override
    public void getAllSortByName() {
        for (Product product : sortByName()) {
            product.getProduct();
        }
    }

    @Override
    public void getAllSortUpByPrice() {
        for (Product product : sortByPrice()) {
            product.getProduct();
        }
    }

    @Override
    public void getByName() {

    }

    public List<Product> sortByName() {
        productList.sort(Comparator.comparing(Product::getName));
        return productList;
    }
    public List<Product> sortByPrice(){
        productList.sort(Comparator.comparing(Product::getPrice));
        return productList;
    }
}
