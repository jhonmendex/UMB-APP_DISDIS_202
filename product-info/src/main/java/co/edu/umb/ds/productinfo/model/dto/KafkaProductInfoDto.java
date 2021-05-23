package co.edu.umb.ds.productinfo.model.dto;

import co.edu.umb.ds.productinfo.model.entities.Category;
import co.edu.umb.ds.productinfo.model.entities.ProductInformation;

import java.util.Set;

public class KafkaProductInfoDto {
    private long id;
    private String name;
    private String description;
    private String path_image;
    private int price;
    private Set<Category> categories ;

    public KafkaProductInfoDto(ProductInformation productInformation) {
        this.id = productInformation.getId();
        this.name = productInformation.getName();
        this.description = productInformation.getDescription();
        this.path_image = productInformation.getPathImage();
        this.price = productInformation.getPrice();
        this.categories = productInformation.getCategories();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath_image() {
        return path_image;
    }

    public void setPath_image(String path_image) {
        this.path_image = path_image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
