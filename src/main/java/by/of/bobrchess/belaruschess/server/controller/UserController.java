package by.of.bobrchess.belaruschess.server.controller;

import by.of.bobrchess.belaruschess.server.entity.User;
import by.of.bobrchess.belaruschess.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return service.getAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable Long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/user?email={email}&password={password}", method = RequestMethod.GET)
    @ResponseBody
    public User authorizateUser(@PathVariable String email, @PathVariable String password) {
        //  return service.getAll().get(id);
        return service.authorizateUser(email,password);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return service.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteUser(@PathVariable Long id) {
        service.remove(id);
    }
}
