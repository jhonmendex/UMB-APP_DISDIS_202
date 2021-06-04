package co.edu.umb.ds.review.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDto {

    @NotNull
    @Positive
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String path_image;

    @NotNull
    private Integer price;

    @NotNull
    private List<CategoryDto> categories;
}
