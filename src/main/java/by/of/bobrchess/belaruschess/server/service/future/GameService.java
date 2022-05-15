package by.of.bobrchess.belaruschess.server.service.future;

import by.of.bobrchess.belaruschess.server.entity.future.Game;

import java.util.List;

public interface GameService {
    List<Game> getAll();

    Game getById(int id);

    Game save(Game game);

    void remove(int id);
}
