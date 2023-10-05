package service.impl;

import model.Category;
import service.CategoryService;
import service.ProductService;

import static controller.ProductController.*;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public void add() {
        Category category = new Category();
        category.input();
        save(category);
    }

    @Override
    public void save(Category category) {
        categoryList.add(category);
    }

    @Override
    public void getAll() {
        for (Category category : categoryList) {
            category.getCategory();
        }
    }

    @Override
    public void update() {
        System.out.println("Nhập vào id Danh mục cần sửa: ");
        int id = Integer.parseInt(sc.nextLine());
        Category category = categoryService.getById(id);
        int indexList = categoryList.indexOf(category);
        Category category1 = new Category();
        if (category != null) {
            category1.setId(category.getId());
            category1.setActive(category.isActive());
            System.out.println("Nhập vào tên danh mục mới");
            String name = sc.nextLine();
            category1.setName(name);
            categoryList.set(indexList, category1);
        } else {
            System.out.println("Null");
        }

    }

    @Override
    public void delete() {
        getAll();
        System.out.println("Nhập vào id Danh mục cần xóa: ");
        int idDelete = Integer.parseInt(sc.nextLine());
        Category category = getById(idDelete);
        if (category != null) {
            if (productService.getProductByCategoryId(idDelete).isEmpty()) {
                categoryList.remove(category);
            } else {
                System.err.println("Danh mục đang có sản phẩm. Không thể xóa!!");
            }
        } else {
            System.err.println("Danh mục không tồn tại!!");
        }
    }

    @Override
    public Category getById(int id) {
        for (Category category : categoryList) {
            if (category.getId() == id) {
                return category;
            } else {
                System.err.println("Danh mục không tồn tại");
            }
        }
        return null;
    }
}
