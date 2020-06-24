package pl.coderslab.charity.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.interfaces.UserService;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

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
    public void saveUser(User user) {
        Role userRole;
        userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        boolean existUser = existsByMail(user.getEmail());
        if (!existUser) {
            userRepository.save(user);
        }
    }

    @Override
    public void saveAdmin(User user) {
        Role adminRole;
        adminRole = roleRepository.findByName("ROLE_ADMIN");
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
    public void changeEnabled(User user) {
        user.setEnabled(true);
        userRepository.save(user);
    }

    @Override
    public void changeDisabled(User user) {
        user.setEnabled(false);
        userRepository.save(user);
    }
}
