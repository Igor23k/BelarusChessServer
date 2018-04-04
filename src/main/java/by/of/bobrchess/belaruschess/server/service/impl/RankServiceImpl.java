package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Rank;
import by.of.bobrchess.belaruschess.server.repository.RankRepository;
import by.of.bobrchess.belaruschess.server.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankRepository repository;

    public List<Rank> getAll() {
        return repository.findAll();
    }

    public Rank getById(int id) {
        return repository.getOne(id);
    }

    public Rank save(Rank rank) {
        return repository.saveAndFlush(rank);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}
