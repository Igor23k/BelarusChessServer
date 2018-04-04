package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.Rank;

import java.util.List;

public interface RankService {
    List<Rank> getAll();

    Rank getById(int id);

    Rank save(Rank rank);

    void remove(int id);
}
