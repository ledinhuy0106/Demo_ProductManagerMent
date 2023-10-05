package controller;

import model.Category;
import model.Product;
import service.CategoryService;
import service.Generals;
import service.ProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    public static Scanner sc = new Scanner(System.in);
    public static List<Category> categoryList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();
    public static int choice;
    public static CategoryService categoryService = new CategoryServiceImpl();
    public static ProductService productService = new ProductServiceImpl();


    public static void main(String[] args) {
        do {
            System.out.println("*****************************Product Management*****************************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Nhập vào lựa chọn của bạn (1-3): ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    categoryManagement();
                    break;
                case 2:
                    productManagement();
                    break;
                case 3:
                    System.out.println("Đã thoát!");
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    public static void categoryManagement() {
        ProductService productService1 = new ProductServiceImpl();
        do {
            System.out.println("*****************************Category*****************************");
            System.out.println("1. Thêm mới danh mục");
            System.out.println("2. Sửa danh mục");
            System.out.println("3. Xóa danh mục");
            System.out.println("4. Hiển thị sản phẩm theo danh mục");
            System.out.println("5. Hiển thị danh sách danh mục");
            System.out.println("6. Quay Lại Product Management");
            System.out.println("7. Thoát");
            System.out.print("Nhập vào lựa chọn của bạn (1-3): ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    categoryService.add();
                    break;
                case 2:
                    categoryService.update();
                    break;
                case 3:
                    categoryService.delete();
                    break;
                case 4:
                    categoryService.getAll();
                    System.out.println("Nhập vào id danh mục");
                    int id = Integer.parseInt(sc.nextLine());
                    productService1.getProductByCategory(id);
                    break;
                case 5:
                    categoryService.getAll();
                    break;
                case 6:
                    System.out.println("Quay Lại Product Management");
                    return;
                case 7:
                    System.out.println("Đang thoát...");
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn không hợp lệ, nhập lại");
            }
        } while (true);
    }

    public static void productManagement() {
        do {
            System.out.println("*****************************Product*****************************");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Danh sách giá sản phẩm tăng dần");
            System.out.println("6. Danh sách tên sản phẩm tăng dần");
            System.out.println("7. Tìm kiếm danh sách tên sản phẩm");
            System.out.println("8. Quay lại Product Management");
            System.out.println("9. Thoát");
            System.out.print("Nhập vào lựa chọn của bạn (1-3): ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    productService.add();
                    break;
                case 2:
                    productService.getAll();
                    break;
                case 3:
                    productService.getAll();
                    productService.update();
                    break;
                case 4:
                    productService.getAll();
                    productService.delete();
                    break;
                case 5:
                    productService.getAllSortUpByPrice();
                    break;
                case 6:
                    productService.getAllSortByName();
                    break;
                case 7:
                    productService.getAll();
                    productService.getByName();
                    break;
                case 8:
                    System.out.println("Quay Lại Product Management");
                    return;
                case 9:
                    System.out.println("Đang thoát...");
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn không hợp lệ, nhập lại");
            }
        } while (true);
    }
}

