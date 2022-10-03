package service;

import model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService implements BaseService {
    static List<Category> categories = new ArrayList<>();

    public String getNameById(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category.getName();
            }
        }
        return null;
    }

    public int getIdByName(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                return category.getId();
            }
        }
        return -1;
    }

    public void add(Category category) {
        for (Category category1 : categories) {
            if (category1.getName().equals(category.getName())) {
                System.out.println("---THIS CATEGORY ALREADY ADDED---");
                return;
            }
        }

        categories.add(category);
        System.out.println("---SUCCESSFULLY ADDED---");
        return;
    }

    @Override
    public void delete(int categoryId) {
        for (Category category : categories) {
            if (category != null) {
                if (category.getId() == categoryId) {
                    categories.remove(category);
                    System.out.println("---SUCCESSFULLY DELETED---");
                    return;
                }
            }
        }
        System.out.println("---SMTH FALSE NOT DELETED---");
    }

    @Override
    public Object getById(int id) {
        for (Category category : categories) {
            if (category != null) {
                if (category.getId() == id)
                    return category;
            }
        }
        return null;
    }

    public void showParentCategories() {
        for (Category category : categories) {
            if (category != null) {
                if (category.getParentId() == 0) {
                    System.out.println(category);
                }
            }
        }
    }

    public void showAllSubCategories() {
        for (Category category : categories) {
            if (category != null && category.getParentId() > 0)
                System.out.println(category);
        }
    }

    public void showSubCategories(int parentId) {
        for (Category category : categories) {
            if (category != null) {
                if (category.getParentId() == parentId) {
                    System.out.println(category);
                }
            }
        }
    }
}
