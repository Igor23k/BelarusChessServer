package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getByEmail(String email);

    User getById(Long id);

    User authorizateUser(String email, String password);

    User save(User u);

    void remove(Long id);
}
