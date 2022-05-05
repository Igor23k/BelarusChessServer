package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    List<User> getUsers(Integer count);
    List<User> getCoaches();
    List<User> getReferees();
    List<User> searchUsers(String text);
    User getByEmail(String email);
    User getById(Long id);
    User register(User u);
    User updateUser(User user);
    void resetPassword(User user);
    void remove(Long id);
}
