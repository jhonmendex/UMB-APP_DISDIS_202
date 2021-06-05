package co.edu.umb.ds.recomendation.model.dto;

import co.edu.umb.ds.recomendation.model.entities.Category;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KafkaProducInfoDto {

    private Long id;
    private String name;
    private String path_image;
    private int price;
    private boolean state;
    private Set<Category> categories;

}
