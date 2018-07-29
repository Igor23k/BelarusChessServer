package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Team;
import by.of.bobrchess.belaruschess.server.repository.TournamentTeamRepository;
import by.of.bobrchess.belaruschess.server.service.TournamentTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentTeamServiceImpl implements TournamentTeamService {

    @Autowired
    private TournamentTeamRepository repository;

    public List<Team> getAll() {
        return repository.findAll();
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
