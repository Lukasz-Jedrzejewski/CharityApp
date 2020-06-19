package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.interfaces.UserService;
import pl.coderslab.charity.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByMail(String mail) {
        return userRepository.findByEmail(mail);
    }

    @Override
    public void saveUser(User user) {

    }
}
