package by.of.bobrchess.belaruschess.server.security.auth.jwt.verifier;

public interface TokenVerifier {
    boolean verify(String jti);
}
