package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category getOne(long id);
    void save(Category category);
    void delete(long id);
    void changeCategoryId(long id);
    void setNullable();
}
