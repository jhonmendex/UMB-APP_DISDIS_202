package co.edu.umb.ds.recomendation.business.service;

import co.edu.umb.ds.recomendation.model.entities.Category;
import co.edu.umb.ds.recomendation.model.enums.CategoryName;
import co.edu.umb.ds.recomendation.model.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public Optional<Category> getByCategoryName(CategoryName categoryName){
        return categoryRepository.findByCategoryName(categoryName);
    }

    public void save(Category category){categoryRepository.save(category);}
}
