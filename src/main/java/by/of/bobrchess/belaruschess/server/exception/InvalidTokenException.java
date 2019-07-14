package by.of.bobrchess.belaruschess.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Invalid JWT Token!")
public class InvalidTokenException extends RuntimeException {
}
