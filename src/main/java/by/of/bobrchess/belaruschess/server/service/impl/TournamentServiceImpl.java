package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Tournament;
import by.of.bobrchess.belaruschess.server.repository.TournamentRepository;
import by.of.bobrchess.belaruschess.server.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(tournament.getId() != null) {
            repository.updateById(tournament.getId(), tournament.getCountPlayersInTeam(), tournament.getFinishDate(),
                    tournament.getFullDescription(), tournament.getImage(), tournament.getName(),
                    tournament.getShortDescription(), tournament.getStartDate(), tournament.getPlace().getId(),
                    tournament.getReferee().getId());
            return getById(tournament.getId());
        }else {
            return repository.saveAndFlush(tournament);
        }
    }

    public void remove(long id) {
        repository.removeById(id);
    }
}
