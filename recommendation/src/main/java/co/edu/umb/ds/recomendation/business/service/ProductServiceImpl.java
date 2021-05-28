package co.edu.umb.ds.recomendation.business.service;

import co.edu.umb.ds.recomendation.model.dto.KafkaProducInfoDto;
import co.edu.umb.ds.recomendation.model.dto.KafkaReviewDto;
import co.edu.umb.ds.recomendation.model.dto.MaessageDto;
import co.edu.umb.ds.recomendation.model.dto.ShowRecommendationDto;
import co.edu.umb.ds.recomendation.model.entities.Category;
import co.edu.umb.ds.recomendation.model.entities.Product;
import co.edu.umb.ds.recomendation.model.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public void updateProductInfo(KafkaProducInfoDto producInfoDto) {
        Product product = new Product(producInfoDto);
        productRepository.save(product);
    }

    public void updateProductReview(KafkaReviewDto reviewDto) {
        Product product = productRepository.findById(reviewDto.getProductId()).get();
        product.setAverage(reviewDto.getAverage());
        productRepository.save(product);
    }

    @Override
    public ResponseEntity<List<ShowRecommendationDto>> findRecommendation(Long idCategory) {
        return null;
    }
}