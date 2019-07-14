package by.of.bobrchess.belaruschess.server.security.model.token;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jsonwebtoken.Claims;

/**
 * Raw representation of JWT Token.
 */
public final class AccessJwtToken implements JwtToken {

    @JsonIgnore
    private Claims claims;
    private final String rawToken;

    protected AccessJwtToken(final String token, Claims claims) {
        this.rawToken = token;
        this.claims = claims;
    }

    public String getToken() {
        return this.rawToken;
    }

    public Claims getClaims() {
        return claims;
    }
}
