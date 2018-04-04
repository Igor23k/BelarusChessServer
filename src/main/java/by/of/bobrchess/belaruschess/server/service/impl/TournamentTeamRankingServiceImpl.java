package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.TournamentTeamRanking;
import by.of.bobrchess.belaruschess.server.repository.TournamentTeamRankingRepository;
import by.of.bobrchess.belaruschess.server.service.TournamentTeamRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentTeamRankingServiceImpl implements TournamentTeamRankingService {

    @Autowired
    private TournamentTeamRankingRepository repository;

    public List<TournamentTeamRanking> getAll() {
        return repository.findAll();
    }

    public TournamentTeamRanking getById(int id) {
        return repository.getOne(id);
    }

    public TournamentTeamRanking save(TournamentTeamRanking tournamentTeamRanking) {
        return repository.saveAndFlush(tournamentTeamRanking);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}
