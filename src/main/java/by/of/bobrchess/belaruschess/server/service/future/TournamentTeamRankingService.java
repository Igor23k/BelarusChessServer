package by.of.bobrchess.belaruschess.server.service.future;

import by.of.bobrchess.belaruschess.server.entity.future.TournamentTeamRanking;

import java.util.List;

public interface TournamentTeamRankingService {
    List<TournamentTeamRanking> getAll();

    TournamentTeamRanking getById(int id);

    TournamentTeamRanking save(TournamentTeamRanking tournamentTeamRanking);

    void remove(int id);
}
