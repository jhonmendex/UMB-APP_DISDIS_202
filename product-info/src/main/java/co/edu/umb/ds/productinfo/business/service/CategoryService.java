package co.edu.umb.ds.productinfo.business.service;

import co.edu.umb.ds.productinfo.model.entities.Category;
import co.edu.umb.ds.productinfo.model.enums.CategoryName;
import co.edu.umb.ds.productinfo.model.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    CategoryRepository categoryRepository;

    public Optional<Category> getByCategoryName(CategoryName categoryName){
        return categoryRepository.findByCategoryName(categoryName);
    }

    public void save(Category category){categoryRepository.save(category);}
}
