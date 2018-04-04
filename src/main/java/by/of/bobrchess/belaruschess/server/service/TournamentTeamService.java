package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.TournamentTeam;

import java.util.List;

public interface TournamentTeamService {
    List<TournamentTeam> getAll();

    TournamentTeam getById(int id);

    TournamentTeam save(TournamentTeam tournamentTeam);

    void remove(int id);
}
