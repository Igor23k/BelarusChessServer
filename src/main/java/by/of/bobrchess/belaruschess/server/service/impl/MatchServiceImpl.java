package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Match;
import by.of.bobrchess.belaruschess.server.repository.MatchRepository;
import by.of.bobrchess.belaruschess.server.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository repository;

    public List<Match> getAll() {
        return repository.findAll();
    }

    public Match getById(int id) {
        return repository.getOne(id);
    }

    public Match save(Match match) {
        return repository.saveAndFlush(match);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}
