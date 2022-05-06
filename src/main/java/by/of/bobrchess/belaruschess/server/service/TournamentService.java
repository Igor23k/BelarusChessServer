package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.Tournament;
import by.of.bobrchess.belaruschess.server.entity.UserTournamentResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TournamentService {
    List<Tournament> getAll();

    List<Tournament> getUpcoming(Boolean upcomingOnly);

    List<Tournament> searchTournaments(String text);

    Tournament getById(long id);

    Tournament save(Tournament tournament, MultipartFile image) throws IOException;

    void remove(long id);

    List<UserTournamentResult> getUserTournamentsResult(long userId, long limit);

    List<UserTournamentResult> getUserTournamentsResult(long userId);
}
