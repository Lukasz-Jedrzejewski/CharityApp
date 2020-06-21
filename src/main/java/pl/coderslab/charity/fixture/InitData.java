package pl.coderslab.charity.fixture;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.service.RoleServiceImpl;

@Service
public class InitData {
    private RoleServiceImpl roleService;


    public void initRoles() {
        Role admin = new Role();
        admin.setName("ROLE_ADMIN");
        roleService.save(admin);

        Role user = new Role();
        user.setName("ROLE_USER");
        roleService.save(user);
    }


}
