package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.Team;

import java.util.List;

public interface TournamentTeamService {
    List<Team> getAll();

    Team getById(int id);

    Team save(Team team);

    void remove(int id);
}
