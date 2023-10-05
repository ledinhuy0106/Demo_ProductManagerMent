package service;

import model.Product;

import java.util.List;

public interface ProductService extends Generals<Product> {
    List<Product> getProductByCategoryId(int id);
    void  getProductByCategory(int id);
    void getAllSortByName();
    void getAllSortUpByPrice();
    void getByName();
}
