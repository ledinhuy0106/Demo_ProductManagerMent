package model;

import static controller.ProductController.sc;

public class Category {
    private int id;
    private String name;
    private boolean active;

    public Category(int id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public Category() {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void input() {
        System.out.println("Vui lòng nhập id danh mục: ");
        id = Integer.parseInt(sc.nextLine());
        System.out.println("Vui lòng nhập tên danh mục: ");
        name = sc.nextLine();
        System.out.println("Vui lòng nhập trạng thái hoạt động sản phẩm: ");
        String isActive = sc.nextLine();
        if (isActive.equals("co")) {
            active = true;
        } else if (isActive.equals("ko")) {
            active = false;
        } else {
            active = false;
        }
    }

    public void getCategory() {
        if (isActive()) {
            System.out.printf("Danh mục %d tên: %s\n", id, name);
        }
    }
}
