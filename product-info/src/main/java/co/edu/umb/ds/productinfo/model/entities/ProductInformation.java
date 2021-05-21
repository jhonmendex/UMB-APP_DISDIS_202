package co.edu.umb.ds.productinfo.model.entities;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "product_information")//nombre de la base de datos
@Table(name = "product_information")
public class ProductInformation {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "path_image", nullable = false, columnDefinition = "TEXT")
    private String pathImage;

    @Column(name ="price", nullable = false, columnDefinition = "INT")
    private int price;

    @Column(name = "state", nullable = false, columnDefinition = "BOOLEAN")
    private boolean state = true;

    @ManyToMany(fetch = FetchType.EAGER)//muchos a muchos
    @JoinTable(name = "category_product_info", joinColumns = @JoinColumn(name = "id_product_info"),
            inverseJoinColumns = @JoinColumn(name = "id_category"))// tabla con dos atributos
    private Set<Category> categories = new HashSet<>();// product_info y lo que contiene el set

    public ProductInformation(String name, String description, String pathImage, int price, Set<Category> categories) {
        this.name = name;
        this.description = description;
        this.pathImage = pathImage;
        this.price = price;
        this.categories = categories;
    }

    public ProductInformation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
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

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
