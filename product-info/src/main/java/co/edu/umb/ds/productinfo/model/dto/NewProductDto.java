package co.edu.umb.ds.productinfo.model.dto;

import co.edu.umb.ds.productinfo.business.exception.ApiRequestException;
import co.edu.umb.ds.productinfo.model.entities.ProductInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

public class NewProductDto {

    private MultipartFile imageFile;
    private ProductInformation productInformation;

    public NewProductDto(MultipartFile imageFile, ProductInformation productInformation) {
        this.imageFile = imageFile;
        this.productInformation = productInformation;
    }

    public NewProductDto() {
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public ProductInformation getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation)  {
        try {
            this.productInformation = new ObjectMapper().readValue(productInformation, ProductInformation.class);
        } catch (JsonProcessingException e) {

            // No se envia de forma correcta los datos del ProductInformation
            throw new ApiRequestException("Verificar mapeo de ProductInformation");

        }
    }

}
