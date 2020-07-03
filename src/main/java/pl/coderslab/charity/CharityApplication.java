package pl.coderslab.charity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.CategoryServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;
import pl.coderslab.charity.service.RoleServiceImpl;
import pl.coderslab.charity.service.UserServiceImpl;


@SpringBootApplication
public class CharityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CharityApplication.class, args);
    }

    private final CategoryServiceImpl categoryService;
    private final InstitutionServiceImpl institutionService;
    private final RoleServiceImpl roleService;
    private final UserServiceImpl userService;

    public CharityApplication(CategoryServiceImpl categoryService, InstitutionServiceImpl institutionService, RoleServiceImpl roleService, UserServiceImpl userService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.setNullable();

        Role superAdmin = new Role();
        superAdmin.setName("ROLE_SUPER ADMIN");
        roleService.save(superAdmin);

        Role admin = new Role();
        admin.setName("ROLE_ADMIN");
        roleService.save(admin);

        Role user = new Role();
        user.setName("ROLE_USER");
        roleService.save(user);

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

        User user1 = new User();
        user1.setFirstName("Admin");
        user1.setLastName("SuperAdmin");
        user1.setEmail("admin@mail.com");
        user1.setPassword("super");
        userService.saveAdmin(user1);
    }
}
