package model;

public class Category extends Base {
    private int parentId;

    public Category() {

    }

    public Category(int parentId) {
        this.parentId = parentId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "(id=" + id + ") " + name.toUpperCase();
    }
}
