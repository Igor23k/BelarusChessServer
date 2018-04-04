package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.Match;

import java.util.List;

public interface MatchService {
    List<Match> getAll();

    Match getById(int id);

    Match save(Match match);

    void remove(int id);
}
