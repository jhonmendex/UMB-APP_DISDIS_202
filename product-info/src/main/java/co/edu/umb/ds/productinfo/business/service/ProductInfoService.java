package co.edu.umb.ds.productinfo.business.service;

import co.edu.umb.ds.productinfo.model.dto.NewProductDto;
import co.edu.umb.ds.productinfo.model.entities.ProductInformation;
import org.springframework.http.ResponseEntity;

public interface ProductInfoService {

    ResponseEntity<ProductInformation> newProduct (NewProductDto newProductDto);

    ResponseEntity<ProductInformation> updateProduct (ProductInformation productInformation);
}
