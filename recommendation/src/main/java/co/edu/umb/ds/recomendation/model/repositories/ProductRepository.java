package co.edu.umb.ds.recomendation.model.repositories;

import co.edu.umb.ds.recomendation.model.entities.Category;
import co.edu.umb.ds.recomendation.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategoriesAndStateTrueOrderByAverage(Category category);
}
