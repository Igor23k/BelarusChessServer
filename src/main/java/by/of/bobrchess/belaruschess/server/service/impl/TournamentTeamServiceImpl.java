package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.TournamentTeam;
import by.of.bobrchess.belaruschess.server.repository.TournamentTeamRepository;
import by.of.bobrchess.belaruschess.server.service.TournamentTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentTeamServiceImpl implements TournamentTeamService {

    @Autowired
    private TournamentTeamRepository repository;

    public List<TournamentTeam> getAll() {
        return repository.findAll();
    }

    public TournamentTeam getById(int id) {
        return repository.getOne(id);
    }

    public TournamentTeam save(TournamentTeam tournamentTeam) {
        return repository.saveAndFlush(tournamentTeam);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}
