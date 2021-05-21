package co.edu.umb.ds.productinfo.business.controller;

import co.edu.umb.ds.productinfo.business.service.ProductInfoServiceImpl;
import co.edu.umb.ds.productinfo.model.entities.ProductInformation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/product")
public class ProductInfoController {


    private  ProductInfoServiceImpl productInfoService;

    public ProductInfoController() {
        this.productInfoService = new ProductInfoServiceImpl();
    }

    @PostMapping("/register")
    public ResponseEntity<ProductInformation> createProduct (@RequestBody ProductInformation productInformation){
        return productInfoService.newProduct(productInformation);
    }
    // toDo update
}