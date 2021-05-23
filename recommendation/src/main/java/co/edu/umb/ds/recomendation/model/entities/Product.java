package co.edu.umb.ds.recomendation.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "average",nullable = false)
    private float average;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "path_image", nullable = false, columnDefinition = "TEXT")
    private String pathImage;

    @Column(name ="price", nullable = false, columnDefinition = "INT")
    private int price;

    @Column(name = "state", nullable = false)
    private boolean state;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "category_routine", joinColumns = @JoinColumn(name = "id_routine"),
            inverseJoinColumns = @JoinColumn(name = "id_cateory"))
    private Set<Category> categories = new HashSet<>();

}
