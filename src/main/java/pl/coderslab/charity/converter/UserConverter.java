package pl.coderslab.charity.converter;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

public class UserConverter implements Converter<String, User> {

    private UserRepository userRepository;

    public UserConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User convert(String id) {
        return userRepository.getOne(Long.parseLong(id));
    }
}
