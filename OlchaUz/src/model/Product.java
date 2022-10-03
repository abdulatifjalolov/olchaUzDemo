package model;

import service.CategoryService;

public class Product extends Base {
    CategoryService categoryService = new CategoryService();
    private double price;
    private double discount;
    private int categoryId;
    private int count;

    public Product(double price, int categoryId, int count) {
        this.price = price;
        this.categoryId = categoryId;
        this.count = count;
    }

    public Product() {
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "● id=(" + id + ") " + name.toUpperCase() + ": \nPRICE= " + price + "\nCOUNT= " + count + "\nCATEGORY: " + categoryService.getNameById(categoryId).toUpperCase() + "\n";
    }
}
