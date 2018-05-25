package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.Tournament;

import java.util.List;

public interface TournamentService {
    List<Tournament> getAll();

    List<Tournament> searchTournaments(String text);

    Tournament getById(int id);

    Tournament save(Tournament tournament);

    void remove(int id);
}
