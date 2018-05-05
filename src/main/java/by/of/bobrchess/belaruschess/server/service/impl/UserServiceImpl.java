package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Country;
import by.of.bobrchess.belaruschess.server.entity.Rank;
import by.of.bobrchess.belaruschess.server.entity.User;
import by.of.bobrchess.belaruschess.server.repository.UserRepository;
import by.of.bobrchess.belaruschess.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

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
        List<User> users = repository.searchUsers(text);
        return users;
    }

    public User getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User getById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public User authorizate(String email, String password) {
        User user = getByEmail(email);
        if(Objects.nonNull(user) && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    public User save(User user) {
        if(Objects.isNull(getByEmail(user.getEmail()))){
           /* if(Objects.isNull(user.getBirthday())){
                user.setBirthday(new Date(System.currentTimeMillis()));
            }*/
            return repository.saveAndFlush(user);
        }
        return null;
    }

    User getTestUser(){
        User userDTO = new User();
        Country countryDTO = new Country();
        countryDTO.setName("BELAR");
        countryDTO.setAbbreviation("blr");
        Rank rankDTO = new Rank();
        rankDTO.setAbbreviation("kek");
        rankDTO.setName("KEKER");
        userDTO.setEmail("ww@dd.ek");
        userDTO.setCountry(countryDTO);
        userDTO.setRank(rankDTO);
        userDTO.setName("Ihar");
        userDTO.setSurname("Kazlou");
        userDTO.setPatronymic("Sergeevich");
        userDTO.setPassword("qwerty");
        userDTO.setRating(2000);
        //userDTO.setBirthday(new Date(System.currentTimeMillis()));
        return userDTO;
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
