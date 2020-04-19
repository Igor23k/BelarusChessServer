package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Tournament;
import by.of.bobrchess.belaruschess.server.entity.UserTournamentResult;
import by.of.bobrchess.belaruschess.server.repository.TournamentRepository;
import by.of.bobrchess.belaruschess.server.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository repository;

    public List<Tournament> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Tournament> searchTournaments(String text) {
        return repository.searchTournaments(text);
    }

    public Tournament getById(long id) {
        return repository.getById(id);
    }

    public Tournament save(Tournament tournament) {
        if (tournament.getId() != null && tournament.getId() != -1) {
            repository.updateById(tournament.getId(), tournament.getCountPlayersInTeam(), tournament.getFinishDate(),
                    tournament.getFullDescription(), tournament.getImage(), tournament.getName(),
                    tournament.getShortDescription(), tournament.getStartDate(), tournament.getPlace().getId(),
                    tournament.getReferee().getId());
            return getById(tournament.getId());
        } else {
            return repository.saveAndFlush(tournament);
        }
    }

    public void remove(long id) {
        repository.removeById(id);
    }

    @Override
    public List<UserTournamentResult> getUserTournamentsResult(long userId, long limit) {
        List<Object[]> list = repository.getUserTournamentsResult(userId, limit);
        List<UserTournamentResult> userTournamentResults = new ArrayList<>();
        for (Object[] result : list) {
            userTournamentResults.add((new UserTournamentResult((String) result[0], (Double) result[1], (Integer) result[2], (String) result[3], (String) result[4])));
        }
        return userTournamentResults;
    }


    @Override
    public List<UserTournamentResult> getUserTournamentsResult(long userId) {
        List<Object[]> list = repository.getUserTournamentsResult(userId);
        List<UserTournamentResult> userTournamentResults = new ArrayList<>();
        for (Object[] result : list) {
            userTournamentResults.add((new UserTournamentResult((String) result[0], (Double) result[1], (Integer) result[2], (String) result[3], (String) result[4])));
        }
        return userTournamentResults;
    }
}
