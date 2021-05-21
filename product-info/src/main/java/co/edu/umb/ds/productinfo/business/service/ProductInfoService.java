package co.edu.umb.ds.productinfo.business.service;

import co.edu.umb.ds.productinfo.model.entities.ProductInformation;
import org.springframework.http.ResponseEntity;

public interface ProductInfoService {

    ResponseEntity<ProductInformation> newProduct (ProductInformation productInformation);

    ResponseEntity<ProductInformation> updateProduct (ProductInformation productInformation);
}
