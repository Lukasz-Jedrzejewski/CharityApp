package pl.coderslab.charity.interfaces;

import pl.coderslab.charity.entity.User;

import java.util.List;

public interface UserService {
    User findByMail(String mail);
    void saveUser(User user);
    void saveAdmin(User user);
    boolean existsByMail(String mail);
    List<User> findAllAdministrators();
    void delete(long id);
    User getOne(long id);
}
