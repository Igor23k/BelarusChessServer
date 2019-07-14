package by.of.bobrchess.belaruschess.server.security.exception;

public class InvalidJwtTokenException extends RuntimeException {
    public InvalidJwtTokenException(String msg) {
        super(msg);
    }
}
