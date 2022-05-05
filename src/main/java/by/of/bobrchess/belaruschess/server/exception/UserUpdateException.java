package by.of.bobrchess.belaruschess.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error occurred while user updating!")
public class UserUpdateException extends RuntimeException {
}
