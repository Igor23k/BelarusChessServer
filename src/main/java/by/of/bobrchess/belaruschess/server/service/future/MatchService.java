package by.of.bobrchess.belaruschess.server.service.future;

import by.of.bobrchess.belaruschess.server.entity.future.Match;

import java.util.List;

public interface MatchService {
    List<Match> getAll();

    Match getById(int id);

    Match save(Match match);

    void remove(int id);
}
