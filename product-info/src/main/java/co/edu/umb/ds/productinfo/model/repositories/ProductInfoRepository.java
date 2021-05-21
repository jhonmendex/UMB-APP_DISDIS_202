package co.edu.umb.ds.productinfo.model.repositories;

import co.edu.umb.ds.productinfo.model.entities.ProductInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ProductInfoRepository extends JpaRepository <ProductInformation, Long> {
}
