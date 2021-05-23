package co.edu.umb.ds.recomendation.model.repositories;

import co.edu.umb.ds.recomendation.model.entities.Category;
import co.edu.umb.ds.recomendation.model.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findById(Long id);
    Optional<Category> findByCategoryName(CategoryName categoryName);

}

