package model;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String color;
    private String description;
    private int id_category;
    private String name_category;

    public Product(int id, String name, double price, int quantity, String color, String description, int id_category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.id_category = id_category;
    }

    public Product(String name, double price, int quantity, String color, String description, int id_category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.id_category = id_category;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public Product(int id, String name, double price, int quantity, String color, String description, int id_category, String name_category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.id_category = id_category;
        this.name_category = name_category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}
