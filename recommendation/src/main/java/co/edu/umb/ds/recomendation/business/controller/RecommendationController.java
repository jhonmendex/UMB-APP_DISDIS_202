package co.edu.umb.ds.recomendation.business.controller;

import co.edu.umb.ds.recomendation.business.service.ProductServiceImpl;
import co.edu.umb.ds.recomendation.model.dto.ShowRecommendationDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/v1/recommendation")
public class RecommendationController {

    private final ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity<List<ShowRecommendationDto>> findRecommendation(@RequestParam Long idCategory){
        return productService.findRecommendation(idCategory);
    }

}
