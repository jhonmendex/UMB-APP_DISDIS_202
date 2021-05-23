package co.edu.umb.ds.productinfo.business.service;

import co.edu.umb.ds.productinfo.business.exception.ApiRequestException;
import co.edu.umb.ds.productinfo.model.dto.MessageDto;
import co.edu.umb.ds.productinfo.model.dto.NewProductDto;
import co.edu.umb.ds.productinfo.model.entities.ProductInformation;
import co.edu.umb.ds.productinfo.model.repositories.ProductInfoRepository;
import co.edu.umb.ds.productinfo.model.util.FileUtil;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.regex.Pattern;

public class ProductInfoServiceImpl implements ProductInfoService{

    private ProductInfoRepository productInfoRepository;
    private KafkaService kafkaService;

    @Override
    public ResponseEntity<ProductInformation> newProduct(NewProductDto newProductDto) {
        ProductInformation productInformation = newProductDto.getProductInformation();
        productInformation.setId((long) (productInfoRepository.findAll().size()+1));

        if (newProductDto.getImageFile() == null) {
            throw new ApiRequestException("No se envió imagen");
        }
        String[] fileExtension = newProductDto.getImageFile().getOriginalFilename().split(Pattern.quote("."));
        String imgName = "img_" + productInformation.getId()
                + "_product." + fileExtension[fileExtension.length - 1];

        productInformation.setPathImage(FileUtil.saveImageProductFile(newProductDto.getImageFile(), imgName));
        productInfoRepository.save(newProductDto.getProductInformation());

        kafkaService.saveProduct(productInformation);
        return new ResponseEntity( new MessageDto("El producto se guardó exitosamente"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductInformation> updateProduct(ProductInformation productInformation) {
        return null;
    }
}
