package model;

import service.CategoryService;
import service.impl.CategoryServiceImpl;

import static controller.ProductController.*;

public class Product {
    private int id;
    private String name;
    private int categoryId;

    private double price;
    private String title;
    private boolean active;

    public Product(String name, int categoryId, double price, String title, boolean active) {
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.title = title;
        this.active = active;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void input() {
        System.out.println("Vui lòng nhập id sản phẩm: ");
        id = Integer.parseInt(sc.nextLine());
        System.out.println("Vui lòng nhập tên sản phẩm: ");
        name = sc.nextLine();
        System.out.println("Vui lòng nhập giá: ");
        price = Double.parseDouble(sc.nextLine());
        System.out.println("Vui lòng nhập tiêu đề sản phẩm: ");
        title = sc.nextLine();
        System.out.println("Vui lòng nhập trạng thái hoạt động sản phẩm: ");
        String isActive = sc.nextLine();
        if (isActive.equals("co")) {
            active = true;
        } else if (isActive.equals("ko")) {
            active = false;
        } else {
            active = false;
        }
        System.out.println("Danh mục: ");
        if (categoryList.isEmpty()){
            categoryService.add();
            categoryId= categoryList.get(0).getId();
        }
        else {
            categoryService.getAll();
            System.out.println("Vui lòng nhập loại sản phẩm(theo số): ");
            int idCat= Integer.parseInt(sc.nextLine());
            Category category= categoryService.getById(idCat);
            categoryId= category.getId();
        }
    }

    public void getProduct() {
        if (isActive()) {
            CategoryService categoryService = new CategoryServiceImpl();
            Category category = categoryService.getById(categoryId);
            System.out.printf("Sản phẩm %d - tên: %s, tiêu đề: %s, giá: %s, loại sản phẩm: %s\n", id, name, title, price, category.getName());
        }
    }
    public void inputUpdate() {
        System.out.println("Vui lòng nhập tên sản phẩm: ");
        name = sc.nextLine();
        System.out.println("Vui lòng nhập giá: ");
        price = Double.parseDouble(sc.nextLine());
        System.out.println("Vui lòng nhập tiêu đề sản phẩm: ");
        title = sc.nextLine();
        System.out.println("Vui lòng nhập trạng thái hoạt động sản phẩm: ");
        String isActive = sc.nextLine();
        if (isActive.equals("co")) {
            active = true;
        } else if (isActive.equals("ko")) {
            active = false;
        } else {
            active = false;
        }
        System.out.println("Danh mục: ");
        if (categoryList.isEmpty()){
            categoryService.add();
            categoryId= categoryList.get(0).getId();
        }
        else {
            categoryService.getAll();
            System.out.println("Vui lòng nhập loại sản phẩm(theo số): ");
            int idCat= Integer.parseInt(sc.nextLine());
            Category category= categoryService.getById(idCat);
            categoryId= category.getId();
        }
    }
}
