package by.of.bobrchess.belaruschess.server.service.future;

import by.of.bobrchess.belaruschess.server.entity.future.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAll();

    List<Team> searchTeams(String text);

    Team getById(int id);

    Team save(Team team);

    void remove(int id);
}
