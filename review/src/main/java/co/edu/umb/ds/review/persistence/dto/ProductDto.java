package co.edu.umb.ds.review.persistence.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

public class ProductDto {

    @NotNull
    @Positive
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String pathName;

    @NotNull
    private Integer price;

    @NotNull
    private List<CategoryDto> categories;
}
