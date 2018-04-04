package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.ChessPlayer;
import by.of.bobrchess.belaruschess.server.entity.Country;
import by.of.bobrchess.belaruschess.server.repository.ChessPlayerRepository;
import by.of.bobrchess.belaruschess.server.repository.CountryRepository;
import by.of.bobrchess.belaruschess.server.service.ChessPlayerService;
import by.of.bobrchess.belaruschess.server.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChessPlayerServiceImpl implements ChessPlayerService {

    @Autowired
    private ChessPlayerRepository repository;

    public List<ChessPlayer> getAll() {
        return repository.findAll();
    }

    public ChessPlayer getById(int id) {
        return repository.getOne(id);
    }

    public ChessPlayer save(ChessPlayer chessPlayer) {
        return repository.saveAndFlush(chessPlayer);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}
