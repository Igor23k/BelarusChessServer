package by.of.bobrchess.belaruschess.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "User doesn't have any assigned roles!")
public class NoAssignedRolesException extends RuntimeException {
}
