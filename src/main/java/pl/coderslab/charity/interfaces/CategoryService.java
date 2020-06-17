package pl.coderslab.charity.interfaces;

import pl.coderslab.charity.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category getOne(long id);
}
