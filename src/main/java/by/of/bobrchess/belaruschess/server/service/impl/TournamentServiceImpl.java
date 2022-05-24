package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Tournament;
import by.of.bobrchess.belaruschess.server.entity.future.UserTournamentResult;
import by.of.bobrchess.belaruschess.server.entity.lite.TournamentLite;
import by.of.bobrchess.belaruschess.server.repository.lite.TournamentLiteRepository;
import by.of.bobrchess.belaruschess.server.repository.TournamentRepository;
import by.of.bobrchess.belaruschess.server.service.TournamentService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository repository;

    @Autowired
    private TournamentLiteRepository repositoryLite;

    public List<Tournament> getAll() {
        return repository.findAll();
    }

    public List<Tournament> getUpcoming(Boolean upcomingOnly) {
        return repository.getUpcomingTournaments(upcomingOnly);
    }

    public List<TournamentLite> getUpcomingLite(Boolean upcomingOnly) {
        return repositoryLite.getUpcomingTournamentsLite(upcomingOnly);
    }

    @Override
    public List<Tournament> searchTournaments(String text) {
        return repository.searchTournaments(text);
    }

    public Tournament getById(long id) {
        return repository.getById(id);
    }

    public Tournament save(Tournament tournament, MultipartFile image, Boolean isImageUpdated) throws IOException {
        if (image != null) {
            tournament.setImage(ArrayUtils.toObject(image.getBytes()));
        }

        if (tournament.getId() != null && tournament.getId() != -1) {
            Byte[] imageArr = isImageUpdated ? tournament.getImage() : repository.getById(tournament.getId()).getImage();

            repository.updateById(tournament.getId(), tournament.getFinishDate(),
                    tournament.getFullDescription(), imageArr, tournament.getName(),
                    tournament.getStartDate(), tournament.getPlace().getId(),
                    tournament.getReferee().getId(), tournament.getToursCount(), tournament.getCreatedBy().getId());
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
