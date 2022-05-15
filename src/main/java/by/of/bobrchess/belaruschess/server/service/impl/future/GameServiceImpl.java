package by.of.bobrchess.belaruschess.server.service.impl.future;

import by.of.bobrchess.belaruschess.server.entity.future.Game;
import by.of.bobrchess.belaruschess.server.repository.future.GameRepository;
import by.of.bobrchess.belaruschess.server.service.future.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository repository;

    public List<Game> getAll() {
        List<Game> games = repository.findAll();
        for (int i = 0; i < games.size(); i++) {
            games.get(i).getMatch().setDate(null);
        }
        return games;
    }

    public Game getById(int id) {
        Game game = repository.getOne(id);
        game.getMatch().setDate(null);
        return game;
    }

    public Game save(Game game) {
        return repository.saveAndFlush(game);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}
