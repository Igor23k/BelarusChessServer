package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Tournament;
import by.of.bobrchess.belaruschess.server.repository.TournamentRepository;
import by.of.bobrchess.belaruschess.server.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository repository;

    public List<Tournament> getAll() {
        return repository.findAll();
    }

    public Tournament getById(int id) {
        return repository.getOne(id);
    }

    public Tournament save(Tournament tournament) {
        return repository.saveAndFlush(tournament);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}
