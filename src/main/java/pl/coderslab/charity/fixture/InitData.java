package pl.coderslab.charity.fixture;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.RoleServiceImpl;
import pl.coderslab.charity.service.UserServiceImpl;

@Service
public class InitData {
    private RoleServiceImpl roleService;
    private UserServiceImpl userService;

    public InitData(RoleServiceImpl roleService, UserServiceImpl userService) {
        this.roleService = roleService;
        this.userService = userService;
    }


    public void initRoles() {
        Role admin = new Role();
        admin.setName("ROLE_ADMIN");
        roleService.save(admin);

        Role user = new Role();
        user.setName("ROLE_USER");
        roleService.save(user);
    }

    public void initSuperAdmin() {
        User user = new User();
        user.setFirstName("Admin");
        user.setLastName("SuperAdmin");
        user.setEmail("SketchAppSender@gmail.com");
        user.setPassword("super");
        userService.saveAdmin(user);
    }
}
