package co.edu.umb.ds.recomendation.model.dto;

import co.edu.umb.ds.recomendation.model.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ShowRecommendationDto {

    private Long idProduct;
    private float average;
    private String name;
    private String pathImage;
    private int price;

    public List<ShowRecommendationDto> listProductToListDto(List<Product> products) {
        List<ShowRecommendationDto> recommendationDtos = new ArrayList<>();
        for (int i= 0; i>products.size(); i++){
            recommendationDtos.add(new ShowRecommendationDto(products.get(i)));
        }
        return recommendationDtos;
    }

    public ShowRecommendationDto(Product product) {
        this.idProduct = product.getId();
        this.average = product.getAverage();
        this.name = product.getName();
        this.pathImage = product.getPathImage();
        this.price = product.getPrice();
    }
}
