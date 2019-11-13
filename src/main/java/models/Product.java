package models;


import java.sql.Array;
import java.util.ArrayList;

public class Product {
    private Long id;
    private Long price;
    private ArrayList<String> images;
    private String name;
    private String description;

    public Product(Long id, Long price, ArrayList<String> images, String name, String description) {
        this.id = id;
        this.price = price;
        this.images = images;
        this.name = name;
        this.description = description;
    }

    public Product(Long price, ArrayList<String> images, String name, String description) {
        this.price = price;
        this.images = images;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public Product setPrice(Long price) {
        this.price = price;
        return this;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public Product setImages(ArrayList<String> images) {
        this.images = images;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }
}
