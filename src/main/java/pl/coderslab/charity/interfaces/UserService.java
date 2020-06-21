package pl.coderslab.charity.interfaces;

import pl.coderslab.charity.entity.User;

public interface UserService {
    User findByMail(String mail);
    void saveUser(User user);
    void saveAdmin(User user);
    boolean existsByMail(String mail);
}
