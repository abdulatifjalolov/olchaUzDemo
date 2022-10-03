package model;

public abstract class Base {
    protected int id;
    private static int idGeneration = 0;
    protected String name;

    public Base() {
        idGeneration++;
        this.id = idGeneration;
    }

    public Base(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
