package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.*;
import by.of.bobrchess.belaruschess.server.repository.UserRepository;
import by.of.bobrchess.belaruschess.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER = "USER";
    private static final String USER_ABBREVIATION = "USER";

    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public List<User> getUsers(Integer count) {
        return repository.getUsers(count);
    }

    @Override
    public List<User> searchUsers(String text) {
        return repository.searchUsers(text);
    }

    @Override
    public User getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<User> getCoaches() {
        return repository.getCoaches();
    }

    @Override
    public User getById(Long id) {
        return repository.getOne(id);
    }

    public User register(User user) {
        if (Objects.isNull(getByEmail(user.getEmail()))) {
            user.setRoles(Collections.singletonList(getStandardUserRole()));
            return repository.saveAndFlush(user);
        }
        return null;
    }

    private UserRole getStandardUserRole() {
        UserRole userRole = new UserRole();
        userRole.setRole(getStandardRole());
        return userRole;
    }

    private Role getStandardRole() {
        Role role = new Role(USER, USER_ABBREVIATION);
        role.setId(3);
        return role;
    }

    User getTestUser() {
        User userDTO = new User();
        Country countryDTO = new Country();
        countryDTO.setName("BELAR");
        countryDTO.setAbbreviation("blr");
        Rank rankDTO = new Rank();
        rankDTO.setAbbreviation("kek");
        rankDTO.setName("KEKER");
        userDTO.setEmail("ww@dd.ek");
        userDTO.setStatus("I love myself!");
        userDTO.setCountry(countryDTO);
        userDTO.setRank(rankDTO);
        userDTO.setName("Ihar");
        userDTO.setSurname("Kazlou");
        userDTO.setPatronymic("Sergeevich");
        userDTO.setPassword("qwerty");
        userDTO.setRating(2000);
        userDTO.setBirthday("23-09-1997");
        return userDTO;
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
