package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.interfaces.RoleService;
import pl.coderslab.charity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(Role role) {
        boolean existUser = existsByName("ROLE_USER");
        boolean existAdmin = existsByName("ROLE_ADMIN");
        if (!existUser || !existAdmin) {
            this.roleRepository.save(role);
        }
    }

    @Override
    public boolean existsByName(String name) {
        return roleRepository.existsRoleByName(name);
    }
}