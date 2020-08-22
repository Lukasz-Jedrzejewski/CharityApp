package pl.coderslab.charity.service;


import pl.coderslab.charity.entity.Role;

public interface RoleService {
    void save(Role role);
    boolean existsByName(String name);
    void deleteByUserId(long id);
}