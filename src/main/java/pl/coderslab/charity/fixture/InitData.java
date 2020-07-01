package pl.coderslab.charity.fixture;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.CategoryServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;
import pl.coderslab.charity.service.RoleServiceImpl;
import pl.coderslab.charity.service.UserServiceImpl;

@Service
public class InitData {
    private RoleServiceImpl roleService;
    private UserServiceImpl userService;
    private CategoryServiceImpl categoryService;
    private InstitutionServiceImpl institutionService;

    public InitData(RoleServiceImpl roleService, UserServiceImpl userService, CategoryServiceImpl categoryService, InstitutionServiceImpl institutionService) {
        this.roleService = roleService;
        this.userService = userService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
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
        user.setEmail("admin@mail.com");
        user.setPassword("super");
        userService.saveAdmin(user);
    }

    public void initCategories() {
        Category category1 = new Category();
        category1.setName("Zabawki");
        categoryService.save(category1);

        Category category2 = new Category();
        category2.setName("Odzież do użytku");
        categoryService.save(category2);

        Category category3 = new Category();
        category3.setName("Sprzęt elektroniczny");
        categoryService.save(category3);

        Category category4 = new Category();
        category4.setName("Książki");
        categoryService.save(category4);

        Category category5 = new Category();
        category5.setName("Inne");
        categoryService.save(category5);
    }

    public void initInstitutions() {
        Institution institution1 = new Institution();
        institution1.setName("All-for-children");
        institution1.setDescription("Pomoc dzieciom z ubogich rodzin");
        institutionService.save(institution1);

        Institution institution2 = new Institution();
        institution2.setName("Nie jesteś sam");
        institution2.setDescription("Pomoc ludziom w trudnej sytuacji");
        institutionService.save(institution2);

        Institution institution3 = new Institution();
        institution3.setName("Dla seniora");
        institution3.setDescription("Pomoc samotnym seniorom");
        institutionService.save(institution3);
    }
}
