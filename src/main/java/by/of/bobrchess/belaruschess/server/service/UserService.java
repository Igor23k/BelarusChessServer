package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.User;
import org.omg.CORBA.portable.InputStream;

import java.util.List;

public interface UserService {
    List<User> getAll();

    List<User> getUsers(Integer count);

    List<User> searchUsers(String text);

    User getByEmail(String email);

    User getById(Long id);

    User authorizate(String email, String password);

    User save(User u);

    void remove(Long id);
}
