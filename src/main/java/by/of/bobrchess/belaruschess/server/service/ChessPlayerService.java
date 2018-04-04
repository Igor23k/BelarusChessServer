package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.ChessPlayer;
import by.of.bobrchess.belaruschess.server.entity.Country;

import java.util.List;

public interface ChessPlayerService {
    List<ChessPlayer> getAll();

    ChessPlayer getById(int id);

    ChessPlayer save(ChessPlayer chessPlayer);

    void remove(int id);
}
