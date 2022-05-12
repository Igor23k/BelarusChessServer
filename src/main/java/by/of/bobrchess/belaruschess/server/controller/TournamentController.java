package by.of.bobrchess.belaruschess.server.controller;

import by.of.bobrchess.belaruschess.server.entity.Tournament;
import by.of.bobrchess.belaruschess.server.entity.UserTournamentResult;
import by.of.bobrchess.belaruschess.server.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class TournamentController {

    @Autowired
    TournamentService service;

    @RequestMapping(value = "/tournaments", method = RequestMethod.GET)
    @ResponseBody
    public List<Tournament> getAllTournaments(@RequestParam Boolean upcomingOnly) {
        return service.getUpcoming(upcomingOnly);
    }

    @RequestMapping(value = "/searchTournaments", method = RequestMethod.GET)
    @ResponseBody
    public List<Tournament> searchTournaments(@RequestParam String text) {
        return service.searchTournaments(text);
    }

    @RequestMapping(value = "/tournament/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Tournament getTournament(@PathVariable long id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/tournament", method = RequestMethod.POST)
    @ResponseBody
    public Tournament addTournament(@RequestPart Tournament tournament, @Nullable @RequestPart("file") MultipartFile image,
                                    @RequestPart Boolean isImageUpdated) throws IOException {
        return service.save(tournament, image, isImageUpdated);
    }

    @RequestMapping(value = "/tournament/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public long deleteTournament(@PathVariable long id) {
        service.remove(id);
        return id;
    }

    @RequestMapping(value = "/tournamentsResultByUser/{userId}/{limit}", method = RequestMethod.GET)
    @ResponseBody
    public List<UserTournamentResult> getUserTournamentsResult(@PathVariable long userId, @PathVariable long limit) {
        return service.getUserTournamentsResult(userId, limit);
    }

    @RequestMapping(value = "/tournamentsResultByUser/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public List<UserTournamentResult> getUserTournamentsResult(@PathVariable long userId) {
        return service.getUserTournamentsResult(userId);
    }
}
