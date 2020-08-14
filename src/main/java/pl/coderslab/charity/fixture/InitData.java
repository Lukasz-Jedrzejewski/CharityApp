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

    private final CategoryServiceImpl categoryService;
    private final InstitutionServiceImpl institutionService;
    private final RoleServiceImpl roleService;
    private final UserServiceImpl userService;

    public InitData(CategoryServiceImpl categoryService, InstitutionServiceImpl institutionService, RoleServiceImpl roleService, UserServiceImpl userService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.roleService = roleService;
        this.userService = userService;
    }

    public void init() {
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
        institution1.setAboutUs("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.");
        institution1.setCity("Gdańsk");
        institution1.setStreet("Romana Dmowkiego 1");
        institution1.setZipCode("11-111");
        institution1.setMail("All-for-children.mail.com");
        institution1.setPhoneNumber("111-111-111");
        institutionService.save(institution1);

        Institution institution2 = new Institution();
        institution2.setName("Nie jesteś sam");
        institution2.setDescription("Pomoc ludziom w trudnej sytuacji");
        institution2.setAboutUs("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Lorem sed risus ultricies tristique. Fringilla ut morbi tincidunt augue interdum velit euismod in. " +
                "Ut diam quam nulla porttitor massa id neque aliquam. " +
                "Scelerisque mauris pellentesque pulvinar pellentesque." +
                " Nec feugiat nisl pretium fusce id velit ut tortor pretium. " +
                "Facilisi etiam dignissim diam quis enim lobortis scelerisque. " +
                "Enim sit amet venenatis urna. Volutpat sed cras ornare arcu dui vivamus arcu felis. " +
                "Leo vel fringilla est ullamcorper eget nulla facilisi etiam dignissim. " +
                "Mauris commodo quis imperdiet massa tincidunt nunc. " +
                "Viverra tellus in hac habitasse platea dictumst vestibulum. " +
                "Ac odio tempor orci dapibus ultrices. " +
                "Orci phasellus egestas tellus rutrum tellus pellentesque eu tincidunt.");
        institution2.setCity("Lublin");
        institution2.setStreet("Ignacego Paderewskiego 2");
        institution2.setZipCode("22-222");
        institution2.setMail("not-alone@mail.com");
        institution2.setPhoneNumber("222-222-222");
        institutionService.save(institution2);

        Institution institution3 = new Institution();
        institution3.setName("Dla seniora");
        institution3.setDescription("Pomoc samotnym seniorom");
        institution3.setAboutUs("Aliquam nulla facilisi cras fermentum odio eu. " +
                "Malesuada pellentesque elit eget gravida. " +
                "Lectus vestibulum mattis ullamcorper velit. " +
                "Sodales ut eu sem integer vitae justo eget magna fermentum. " +
                "Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada. " +
                "Aliquet bibendum enim facilisis gravida neque convallis a cras semper. " +
                "Ipsum dolor sit amet consectetur adipiscing elit duis tristique sollicitudin. " +
                "Libero volutpat sed cras ornare arcu dui vivamus arcu felis. " +
                "Dignissim diam quis enim lobortis scelerisque fermentum dui faucibus in. " +
                "Senectus et netus et malesuada fames ac turpis egestas.");
        institution3.setCity("Katowice");
        institution3.setStreet("Gabriela Narutowicza 3");
        institution3.setZipCode("33-333");
        institution3.setMail("4senior@mail.com");
        institution3.setPhoneNumber("333-333-333");
        institutionService.save(institution3);

        User user1 = new User();
        user1.setFirstName("Admin");
        user1.setLastName("SuperAdmin");
        user1.setEmail("admin@mail.com");
        user1.setPassword("super");
        userService.saveAdmin(user1);
    }
}
