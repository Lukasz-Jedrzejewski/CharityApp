package pl.coderslab.charity.interfaces;

import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.model.UserModel;

import java.util.List;

public interface UserService {
    User findByMail(String mail);
    void saveUser(User user, UserModel userModel);
    void saveAdmin(User user);
    boolean existsByMail(String mail);
    List<User> findAllAdministrators();
    void delete(long id);
    User getOne(long id);
    List<User> findAllUsers();
    void changeEnabled(User user);
    void changeDisabled(User user);
    void editUser(User user);
    void changePass(User user);
    void save(User user);
}
