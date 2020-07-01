package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.interfaces.CategoryService;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getOne(long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public void save(Category category) {
        boolean existCategory = categoryRepository.existsCategoryByName(category.getName());
        if (!existCategory) {
            categoryRepository.save(category);
        }
    }

    @Override
    public void delete(long id) {
        categoryRepository.delete(getOne(id));
    }
}
