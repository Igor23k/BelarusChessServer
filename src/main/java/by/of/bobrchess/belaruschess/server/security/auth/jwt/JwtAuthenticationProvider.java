package by.of.bobrchess.belaruschess.server.security.auth.jwt;

import by.of.bobrchess.belaruschess.server.entity.User;
import by.of.bobrchess.belaruschess.server.entity.UserContext;
import by.of.bobrchess.belaruschess.server.exception.UserScopesAreEmptyException;
import by.of.bobrchess.belaruschess.server.security.auth.JwtAuthenticationToken;
import by.of.bobrchess.belaruschess.server.security.config.JwtSettings;
import by.of.bobrchess.belaruschess.server.security.model.token.JwtToken;
import by.of.bobrchess.belaruschess.server.security.model.token.RawAccessJwtToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static by.of.bobrchess.belaruschess.server.util.Constants.SCOPES;
import static by.of.bobrchess.belaruschess.server.util.Util.buildAuthorities;

/**
 * An {@link AuthenticationProvider} implementation that will use provided
 * instance of {@link JwtToken} to perform authentication.
 */
@Component
@SuppressWarnings("unchecked")
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private final JwtSettings jwtSettings;

    @Autowired
    public JwtAuthenticationProvider(JwtSettings jwtSettings) {
        this.jwtSettings = jwtSettings;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RawAccessJwtToken rawAccessToken = (RawAccessJwtToken) authentication.getCredentials();
        Jws<Claims> jwsClaims = Optional.of(rawAccessToken.parseClaims(jwtSettings.getTokenSigningKey())).orElseThrow(UserScopesAreEmptyException::new);
        List<String> scopes = Optional.of(jwsClaims.getBody().get(SCOPES, List.class)).orElseThrow(UserScopesAreEmptyException::new);
        return new JwtAuthenticationToken(jwsClaims.getBody().getSubject(), buildAuthorities(scopes));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
