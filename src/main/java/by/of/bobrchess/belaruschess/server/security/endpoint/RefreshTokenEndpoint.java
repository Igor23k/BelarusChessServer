package by.of.bobrchess.belaruschess.server.security.endpoint;

import by.of.bobrchess.belaruschess.server.entity.User;
import by.of.bobrchess.belaruschess.server.exception.ExpiredTokenException;
import by.of.bobrchess.belaruschess.server.security.auth.jwt.extractor.TokenExtractor;
import by.of.bobrchess.belaruschess.server.security.auth.jwt.verifier.TokenVerifier;
import by.of.bobrchess.belaruschess.server.security.config.JwtSettings;
import by.of.bobrchess.belaruschess.server.security.config.WebSecurityConfig;
import by.of.bobrchess.belaruschess.server.security.exception.InvalidJwtTokenException;
import by.of.bobrchess.belaruschess.server.security.model.token.JwtToken;
import by.of.bobrchess.belaruschess.server.security.model.token.JwtTokenFactory;
import by.of.bobrchess.belaruschess.server.security.model.token.RawAccessJwtToken;
import by.of.bobrchess.belaruschess.server.security.model.token.RefreshToken;
import by.of.bobrchess.belaruschess.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

import static by.of.bobrchess.belaruschess.server.util.Util.buildAuthorities;

@RestController
public class RefreshTokenEndpoint {
    private final JwtTokenFactory tokenFactory;
    private final JwtSettings jwtSettings;
    private final UserService userService;
    private final TokenVerifier tokenVerifier;
    private final TokenExtractor tokenExtractor;

    public RefreshTokenEndpoint(JwtTokenFactory tokenFactory, JwtSettings jwtSettings, UserService userService, TokenVerifier tokenVerifier, @Qualifier("jwtHeaderTokenExtractor") TokenExtractor tokenExtractor) {
        this.tokenFactory = tokenFactory;
        this.jwtSettings = jwtSettings;
        this.userService = userService;
        this.tokenVerifier = tokenVerifier;
        this.tokenExtractor = tokenExtractor;
    }

    @RequestMapping(value = "/api/auth/token", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    JwtToken refreshToken(HttpServletRequest request) {
        String tokenPayload = tokenExtractor.extract(request.getHeader(WebSecurityConfig.AUTHENTICATION_HEADER_NAME));

        RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(rawToken, jwtSettings.getTokenSigningKey()).orElseThrow(() -> new InvalidJwtTokenException("Invalid Jwt Token: " + rawToken));

        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new ExpiredTokenException();
        }

        String subject = refreshToken.getSubject();
        User user = userService.getByEmail(subject);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("User not found: " + subject);
        }

        if (user.getRoles() == null) throw new InsufficientAuthenticationException("User has no roles assigned!");

        return tokenFactory.createAccessJwtToken(user, buildAuthorities(user));
    }
}
