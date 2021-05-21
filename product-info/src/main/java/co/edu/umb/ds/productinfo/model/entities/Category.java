package co.edu.umb.ds.productinfo.model.entities;

import co.edu.umb.ds.productinfo.model.enums.CategoryName;
import com.sun.istack.NotNull;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;

@Entity(name = "category")//nombre de la base de datos
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoryName categoryName;

    public Category(CategoryName categoryName) {
        this.categoryName = categoryName;
    }
}
