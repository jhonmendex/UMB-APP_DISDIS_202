package co.edu.umb.ds.recomendation.business.service;

import co.edu.umb.ds.recomendation.model.dto.ShowRecommendationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RecommendationServiceImpl implements RecommendationService{

    @Override
    public ResponseEntity<List<ShowRecommendationDto>> findRecommendation(Long idCategory) {
        return null;
    }
}
