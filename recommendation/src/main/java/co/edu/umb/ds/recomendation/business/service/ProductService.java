package co.edu.umb.ds.recomendation.business.service;

import co.edu.umb.ds.recomendation.model.dto.KafkaProducInfoDto;
import co.edu.umb.ds.recomendation.model.dto.KafkaReviewDto;
import co.edu.umb.ds.recomendation.model.entities.Product;
import co.edu.umb.ds.recomendation.model.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    private ProductRepository productRepository;

    public void updateProductInfo(KafkaProducInfoDto producInfoDto) {
        Product product = new Product(producInfoDto);
        productRepository.save(product);
    }

    public void updateProductReview(KafkaReviewDto reviewDto) {
        Product product = new Product(reviewDto);
        productRepository.save(product);
    }
}