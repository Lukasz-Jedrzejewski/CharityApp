package pl.coderslab.charity.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.interfaces.UserService;
import pl.coderslab.charity.model.UserModel;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByMail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user, UserModel userModel) {
        Role userRole;
        userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setEnabled(false);
        boolean existUser = existsByMail(user.getEmail());
        if (!existUser) {
            userRepository.save(user);
        }
    }

    @Override
    public void saveAdmin(User user) {
        Role adminRole;
        adminRole = roleRepository.findByName("ROLE_SUPER ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(adminRole)));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        boolean existAdmin = existsByMail(user.getEmail());
        if (!existAdmin) {
            userRepository.save(user);
        }
    }

    @Override
    public boolean existsByMail(String mail) {
        return userRepository.existsUserByEmail(mail);
    }

    @Override
    public List<User> findAllAdministrators() {
        return userRepository.findAllByRoleAdminCustomQuery();
    }

    @Override
    public void delete(long id) {
        userRepository.delete(getOne(id));
    }

    @Override
    public User getOne(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAllByRoleUserCustomQuery();
    }

    @Override
    public void changeStatus(User user) {
        if (user.isEnabled()) {
            user.setEnabled(false);
        } else {
            user.setEnabled(true);
        }
        userRepository.save(user);
    }

    @Override
    public void editUser(User user) {
        User userDb = userRepository.getOne(user.getId());
        user.setEnabled(userDb.isEnabled());
        user.setRoles(userDb.getRoles());
        user.setPassword(userDb.getPassword());
        userRepository.save(user);
    }

    @Override
    public void changePass(User user) {
        User userDb = userRepository.getOne(user.getId());
        user.setEnabled(userDb.isEnabled());
        user.setRoles(userDb.getRoles());
        user.setFirstName(userDb.getFirstName());
        user.setLastName(userDb.getLastName());
        user.setEmail(userDb.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void save(User user) {
        Role userRole;
        userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false);
        boolean existUser = existsByMail(user.getEmail());
        if (!existUser) {
            userRepository.save(user);
        }
    }

    @Override
    public void changeSuperAdminMail(User user) {
        User userDb = userRepository.getOne(user.getId());
        user.setFirstName(userDb.getFirstName());
        user.setLastName(userDb.getLastName());
        user.setEnabled(userDb.isEnabled());
        user.setRoles(userDb.getRoles());
        user.setPassword(userDb.getPassword());
        userRepository.save(user);
    }
}
