package co.edu.umb.ds.recomendation.model.entities;

import co.edu.umb.ds.recomendation.model.enums.CategoryName;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "category")
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoryName categoryName;

    public Category(@NotNull CategoryName categoryName) {
        this.categoryName = categoryName;
    }
}