package co.edu.umb.ds.review.persistence.repositories;

import co.edu.umb.ds.review.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
