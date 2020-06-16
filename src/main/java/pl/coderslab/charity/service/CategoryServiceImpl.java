package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.interfaces.CategoryService;
import pl.coderslab.charity.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
