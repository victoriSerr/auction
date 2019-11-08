package models;


import java.sql.Array;

public class Product {
    private Long id;
    private Long price;
    private Array images;
    private String name;
    private String description;

    public Product(Long id, Long price, Array images, String name, String description) {
        this.id = id;
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

    public Array getImages() {
        return images;
    }

    public Product setImages(Array images) {
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
