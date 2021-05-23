package co.edu.umb.ds.productinfo.model.loader;

import co.edu.umb.ds.productinfo.business.service.CategoryService;
import co.edu.umb.ds.productinfo.model.entities.Category;
import co.edu.umb.ds.productinfo.model.enums.CategoryName;
import co.edu.umb.ds.productinfo.model.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoryLoader implements CommandLineRunner{
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {

        Category categoryBook = new Category(CategoryName.LIBROS);
        Category categoryTechnology = new Category(CategoryName.TECNOLOGIA);
        Category categorySport = new Category(CategoryName.DEPORTE);
        Category categoryVideoGame = new Category(CategoryName.VIDEOJUEGOS);
        Category categoryPet = new Category(CategoryName.MASCOTAS);

        categoryRepository.save(categoryBook);
        categoryRepository.save(categoryTechnology);
        categoryRepository.save(categorySport);
        categoryRepository.save(categoryVideoGame);
        categoryRepository.save(categoryPet);
    }
}
