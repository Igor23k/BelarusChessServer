package by.of.bobrchess.belaruschess.server.controller;

import by.of.bobrchess.belaruschess.server.entity.Tournament;
import by.of.bobrchess.belaruschess.server.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TournamentController {

    @Autowired
    TournamentService service;

    @RequestMapping(value = "/tournaments", method = RequestMethod.GET)
    @ResponseBody
    public List<Tournament> getAllTournaments() {
        return service.getAll();
    }

    @RequestMapping(value = "/searchTournaments", method = RequestMethod.GET)
    @ResponseBody
    public List<Tournament> searchTournaments(@RequestParam String text) {
        return service.searchTournaments(text);
    }

    @RequestMapping(value = "/tournament/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Tournament getTournament(@PathVariable int id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/tournament", method = RequestMethod.POST)
    @ResponseBody
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return service.save(tournament);
    }

    @RequestMapping(value = "/tournament/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTournament(@PathVariable int id) {
        service.remove(id);
    }
}
