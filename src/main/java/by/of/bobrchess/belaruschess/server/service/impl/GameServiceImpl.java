package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Game;
import by.of.bobrchess.belaruschess.server.repository.GameRepository;
import by.of.bobrchess.belaruschess.server.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository repository;

    public List<Game> getAll() {
        return repository.findAll();
    }

    public Game getById(int id) {
        return repository.getOne(id);
    }

    public Game save(Game game) {
        return repository.saveAndFlush(game);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}
