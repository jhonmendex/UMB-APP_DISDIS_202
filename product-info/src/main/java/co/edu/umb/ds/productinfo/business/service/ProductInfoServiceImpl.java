package co.edu.umb.ds.productinfo.business.service;

import co.edu.umb.ds.productinfo.model.entities.ProductInformation;
import co.edu.umb.ds.productinfo.model.repositories.ProductInfoRepository;
import org.springframework.http.ResponseEntity;

public class ProductInfoServiceImpl implements ProductInfoService{

    private ProductInfoRepository productInfoRepository;

    @Override
    public ResponseEntity<ProductInformation> newProduct(ProductInformation productInformation) {
        productInfoRepository.save(productInformation);
        return null;
    }

    @Override
    public ResponseEntity<ProductInformation> updateProduct(ProductInformation productInformation) {
        return null;
    }
}
