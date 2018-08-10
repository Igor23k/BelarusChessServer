package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Team;
import by.of.bobrchess.belaruschess.server.entity.Tournament;
import by.of.bobrchess.belaruschess.server.repository.TeamRepository;
import by.of.bobrchess.belaruschess.server.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository repository;

    public List<Team> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Team> searchTeams(String text) {
        return repository.searchTeams(text);
    }

    public Team getById(int id) {
        return repository.getOne(id);
    }

    public Team save(Team team) {
        return repository.saveAndFlush(team);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}
