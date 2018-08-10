package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.Team;
import by.of.bobrchess.belaruschess.server.entity.Tournament;

import java.util.List;

public interface TeamService {
    List<Team> getAll();

    List<Team> searchTeams(String text);

    Team getById(int id);

    Team save(Team team);

    void remove(int id);
}
