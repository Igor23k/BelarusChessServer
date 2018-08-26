package by.of.bobrchess.belaruschess.server.controller;

import by.of.bobrchess.belaruschess.server.entity.User;
import by.of.bobrchess.belaruschess.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return service.getAll();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(@RequestParam Integer count) {
        return service.getUsers(count);
    }

    @RequestMapping(value = "/searchUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> searchUsers(@RequestParam String text) {
        return service.searchUsers(text);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public User authorizateUser(@RequestBody User user, HttpServletResponse response) {
        user = service.authorizate(user.getEmail(), user.getPassword());
        if (Objects.isNull(user)) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            response.setHeader("Error", "Authorizate is failed!");
        }
        return user;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public User addUser(@RequestBody User user, HttpServletResponse response) {
        user = service.save(user);
        if (Objects.isNull(user)) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            response.setHeader("Error", "User with this email already exists!");
        }
        return user;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable Long id) {
        service.remove(id);
    }
}
