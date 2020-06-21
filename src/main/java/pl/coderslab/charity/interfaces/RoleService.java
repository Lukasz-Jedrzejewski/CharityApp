package pl.coderslab.charity.interfaces;


import pl.coderslab.charity.entity.Role;

public interface RoleService {
    void save(Role role);

    boolean existsByName(String name);
}