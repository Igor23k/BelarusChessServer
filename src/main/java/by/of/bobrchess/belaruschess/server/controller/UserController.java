package by.of.bobrchess.belaruschess.server.controller;

import by.of.bobrchess.belaruschess.server.entity.User;
import by.of.bobrchess.belaruschess.server.entity.UserContext;
import by.of.bobrchess.belaruschess.server.exception.*;
import by.of.bobrchess.belaruschess.server.security.auth.JwtAuthenticationToken;
import by.of.bobrchess.belaruschess.server.security.model.token.JwtToken;
import by.of.bobrchess.belaruschess.server.security.model.token.JwtTokenFactory;
import by.of.bobrchess.belaruschess.server.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

import static by.of.bobrchess.belaruschess.server.util.Constants.ROLE_ADMIN;
import static by.of.bobrchess.belaruschess.server.util.Util.*;

@RestController
public class UserController {

    private final JwtTokenFactory tokenFactory;
    private final UserService service;

    public UserController(JwtTokenFactory tokenFactory, UserService service) {
        this.tokenFactory = tokenFactory;
        this.service = service;
    }

    @RequestMapping(value = "/api/allUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers(HttpServletRequest request) {
        if (hasSufficientRights(request, ROLE_ADMIN)) {
            return service.getAll();
        }
        throw new NoSufficientRightsException();
    }

    @RequestMapping(value = "/api/coaches", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getCoaches(HttpServletRequest request) {
        if (hasSufficientRights(request, ROLE_ADMIN)) {
            return service.getCoaches();
        }
        throw new NoSufficientRightsException();
    }

    @RequestMapping(value = "/api/referees", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getReferees(HttpServletRequest request) {
        if (hasSufficientRights(request, ROLE_ADMIN)) {
            return service.getReferees();
        }
        throw new NoSufficientRightsException();
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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public UserContext register(@RequestBody User user) {
        user = Optional.ofNullable(service.register(user)).orElseThrow(UserAlreadyExistsException::new);
        JwtToken accessToken = tokenFactory.createAccessJwtToken(user, buildAuthorities(user));
        JwtToken refreshToken = tokenFactory.createRefreshToken(user);
        return new UserContext(user, buildTokenMap(accessToken, refreshToken));
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return Optional.ofNullable(service.updateUser(user)).orElseThrow(UserAlreadyExistsException::new);
    }

    @RequestMapping(value = "/api/me", method = RequestMethod.GET)
    @ResponseBody
    public User get(JwtAuthenticationToken token) {
        //throw new ExpiredTokenException();
        String email = Optional.ofNullable((String) token.getPrincipal()).orElseThrow(InvalidTokenException::new);
        return Optional.ofNullable(service.getByEmail(email)).orElseThrow(InvalidTokenException::new);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable Long id) {
        service.remove(id);
    }
}
