package by.of.bobrchess.belaruschess.server.controller;

import by.of.bobrchess.belaruschess.server.entity.User;
import by.of.bobrchess.belaruschess.server.entity.UserContext;
import by.of.bobrchess.belaruschess.server.exception.InvalidTokenException;
import by.of.bobrchess.belaruschess.server.exception.NoSufficientRightsException;
import by.of.bobrchess.belaruschess.server.exception.UserAlreadyExistsException;
import by.of.bobrchess.belaruschess.server.exception.UserUpdateException;
import by.of.bobrchess.belaruschess.server.security.auth.JwtAuthenticationToken;
import by.of.bobrchess.belaruschess.server.security.model.token.JwtToken;
import by.of.bobrchess.belaruschess.server.security.model.token.JwtTokenFactory;
import by.of.bobrchess.belaruschess.server.service.UserService;
import by.of.bobrchess.belaruschess.server.service.impl.EmailSenderServiceImpl;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static by.of.bobrchess.belaruschess.server.util.Constants.ROLE_ADMIN;
import static by.of.bobrchess.belaruschess.server.util.Constants.ROLE_ORGANIZER;
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

    @RequestMapping(value = "/coaches", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getCoaches() {
        return service.getCoaches();
    }

    @RequestMapping(value = "/api/referees", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getReferees(HttpServletRequest request) {
        if (hasSufficientRights(request, ROLE_ADMIN) || hasSufficientRights(request, ROLE_ORGANIZER)) {
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
    public UserContext register(@RequestPart User user, @Nullable @RequestPart("file") MultipartFile image) throws IOException {
        user = Optional.ofNullable(service.register(user, image)).orElseThrow(UserAlreadyExistsException::new);
        JwtToken accessToken = tokenFactory.createAccessJwtToken(user, buildAuthorities(user));
        JwtToken refreshToken = tokenFactory.createRefreshToken(user);
        return new UserContext(user, buildTokenMap(accessToken, refreshToken));
    }

    @RequestMapping(value = "/api/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public User updateUser(@RequestPart User user, @Nullable @RequestPart("file") MultipartFile image) throws IOException {
        return Optional.ofNullable(service.updateUser(user, image)).orElseThrow(UserUpdateException::new);
    }

    @RequestMapping(value = "/api/resetPassword", method = RequestMethod.POST)
    @ResponseBody
    public Boolean resetPassword(@RequestBody String email) {
        try {
            EmailSenderServiceImpl emailSender = new EmailSenderServiceImpl("bobrchess@gmail.com", "cbanrmwaavlakudf");
            emailSender.send("This is Subject", "TLS: This is test!", "support@devcolibri.com", "n1ceonjke@gmail.com");
            service.resetPassword(email);
            return true;
        } catch (UserUpdateException e) {
            return false;
        }
    }

    @RequestMapping(value = "/api/me", method = RequestMethod.GET)
    @ResponseBody
    public User get(JwtAuthenticationToken token) {
        String email = Optional.ofNullable((String) token.getPrincipal()).orElseThrow(InvalidTokenException::new);
        return Optional.ofNullable(service.getByEmail(email)).orElseThrow(InvalidTokenException::new);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable Long id) {
        service.remove(id);
    }
}
