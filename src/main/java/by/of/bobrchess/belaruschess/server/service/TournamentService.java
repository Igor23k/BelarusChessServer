package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.Tournament;
import by.of.bobrchess.belaruschess.server.entity.future.UserTournamentResult;
import by.of.bobrchess.belaruschess.server.entity.lite.TournamentLite;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TournamentService {
    List<Tournament> getAll();

    List<Tournament> getUpcoming(Boolean upcomingOnly);
    List<TournamentLite> getUpcomingLite(Boolean upcomingOnly);

    List<Tournament> searchTournaments(String text);

    Tournament getById(long id);

    Tournament save(Tournament tournament, MultipartFile image, Boolean isImageUpdated) throws IOException;

    void remove(long id);

    List<UserTournamentResult> getUserTournamentsResult(long userId, long limit);

    List<UserTournamentResult> getUserTournamentsResult(long userId);
}
