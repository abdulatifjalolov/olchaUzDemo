package service;

import model.Base;
import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements BaseService {
    static List<Product> products = new ArrayList<>();

    public String getNameById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product.getName();
            }
        }
        return null;
    }

    public void add(Product product) {
        for (Product product1 : products) {
            if (product1 != null) {
                if (product1.getName().equals(product.getName())) {
                    System.out.println("---THIS PRODUCT ALREADY ADDED---");
                    return;
                }
            }
        }
        for (Category category : CategoryService.categories) {
            if (category.getId() == product.getCategoryId() && getById(product.getCategoryId()) == null) {
                products.add(product);
                System.out.println("---SUCCESSFULLY ADDED---");
                return;
            }
        }
    }

    public void showList() {
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
    }

    @Override
    public void delete(int productId) {
        for (Product product : products) {
            if (product != null) {
                if (product.getId() == productId) {
                    products.remove(product);
                    System.out.println("---SUCCESSFULLY DELETED---");
                    return;
                }
            }
        }
        System.out.println("---SMTH FALSE NOT DELETED---");
    }

    @Override
    public Object getById(int productId) {
        for (Product product : products) {
            if (product != null) {
                if (product.getId() == productId) {
                    return product;
                }
            }
        }
        return null;
    }

    public Product showProductsByCategoryId(int categoryId) {
        for (Product product : products) {
            if (product != null) {
                if (product.getCategoryId() == categoryId) {
                    return product;
                }
            }
        }
        return null;
    }

    public void showProductsByCategoryId1(int categoryId) {
        for (Product product1 : products) {
            if (product1 != null) {
                if (product1.getCategoryId() == categoryId) {
                    System.out.println(product1);
                }
            }
        }
    }

}
