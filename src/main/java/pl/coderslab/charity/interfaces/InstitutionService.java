package pl.coderslab.charity.interfaces;

import pl.coderslab.charity.entity.Institution;

import java.util.List;

public interface InstitutionService {
    List<Institution> findAll();
    void delete(long id);
    Institution getOne(long id);
    void save(Institution institution);
}
