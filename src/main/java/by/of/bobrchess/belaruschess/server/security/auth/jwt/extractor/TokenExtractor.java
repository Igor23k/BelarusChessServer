package by.of.bobrchess.belaruschess.server.security.auth.jwt.extractor;

public interface TokenExtractor {
    String extract(String payload);
}
