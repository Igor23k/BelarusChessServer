package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Role;
import by.of.bobrchess.belaruschess.server.entity.User;
import by.of.bobrchess.belaruschess.server.entity.UserRole;
import by.of.bobrchess.belaruschess.server.exception.UserUpdateException;
import by.of.bobrchess.belaruschess.server.repository.UserRepository;
import by.of.bobrchess.belaruschess.server.service.UserService;
import by.of.bobrchess.belaruschess.server.util.Util;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static by.of.bobrchess.belaruschess.server.service.impl.PasswordGeneratorServiceImpl.generateRandomPassword;

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
    public List<User> getReferees() {
        return repository.getReferees();
    }

    @Override
    public User getById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public User register(User user, MultipartFile image) throws IOException {
        if (Objects.isNull(getByEmail(user.getEmail()))) {
            if (image != null) {
                user.setImage(ArrayUtils.toObject(image.getBytes()));
            }

            user.setRoles(Collections.singletonList(getStandardUserRole()));
            return repository.saveAndFlush(user);
        }
        return null;
    }

    @Override
    public User updateUser(User user, MultipartFile image) {
        try {
            if (image != null) {
                user.setImage(ArrayUtils.toObject(image.getBytes()));
            }

            User dbUser = repository.getOne(user.getId());
            user.setRoles(dbUser.getRoles());

            repository.updateById(user.getId(), user.getName(), user.getSurname(),
                    user.getPatronymic(), user.getBirthday(), user.getEmail(),
                    user.getPassword(), user.getBeCoach(),
                    user.getBeAdmin(), user.getBeOrganizer(), user.getBeMale(),
                    user.getRank().getId(), user.getCountry().getId(),
                    user.getRating(), user.getCoach(), user.getImage());
            return getById(user.getId());
        } catch (Exception e) {
            throw new UserUpdateException();
        }
    }

    @Override
    public void resetPassword(String email, String newPassword) {
        try {
            User dbUser = repository.findByEmail(email);
            dbUser.setRoles(dbUser.getRoles());

            repository.updateById(dbUser.getId(), dbUser.getName(), dbUser.getSurname(),
                    dbUser.getPatronymic(), dbUser.getBirthday(), dbUser.getEmail(),
                    Util.getEncodedPassword(newPassword), dbUser.getBeCoach(),
                    dbUser.getBeAdmin(), dbUser.getBeOrganizer(), dbUser.getBeMale(),
                    dbUser.getRank().getId(), dbUser.getCountry().getId(),
                    dbUser.getRating(), dbUser.getCoach(), dbUser.getImage());
        } catch (Exception e) {
            throw new UserUpdateException();
        }
    }

    private Long getCoachId(User coach) {
        Long coachId = null;
        if (coach != null) {
            coachId = coach.getId();
        }
        return coachId;
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

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
