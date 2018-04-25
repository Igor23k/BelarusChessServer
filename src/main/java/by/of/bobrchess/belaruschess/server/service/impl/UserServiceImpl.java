package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.User;
import by.of.bobrchess.belaruschess.server.repository.UserRepository;
import by.of.bobrchess.belaruschess.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getByEmail(String email) {
        return null;
    }

    @Override
    public User getById(Long id) {
        User user = repository.getOne(id);
        return user;
    }

    @Override
    public User authorizateUser(String email, String password) {
        return null;
    }

    public User save(User user) {
        if(Objects.isNull(getByEmail(user.getEmail()))){
            return repository.saveAndFlush(user);
        }
        return null;
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
