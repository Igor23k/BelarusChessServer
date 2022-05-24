package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.User;
import by.of.bobrchess.belaruschess.server.entity.lite.UserLite;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<User> getAll();
    List<UserLite> getAllLite();
    List<User> getUsers(Integer count);
    List<User> getCoaches();
    List<User> getReferees();
    List<User> searchUsers(String text);
    User getByEmail(String email);
    User getById(Long id);
    User register(User user, MultipartFile image) throws IOException;
    User updateUser(User user, MultipartFile image);
    void resetPassword(String email);
    void remove(Long id);
}
