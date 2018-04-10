package by.of.bobrchess.belaruschess.server.controller;

import by.of.bobrchess.belaruschess.server.entity.Match;
import by.of.bobrchess.belaruschess.server.entity.Place;
import by.of.bobrchess.belaruschess.server.service.MatchService;
import by.of.bobrchess.belaruschess.server.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchController {

    @Autowired
    MatchService service;

    @RequestMapping(value = "/matches", method = RequestMethod.GET)
    @ResponseBody
    public List<Match> getAllMatches() {
        return service.getAll();
    }

    @RequestMapping(value = "/match/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Match getMatch(@PathVariable int id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/match", method = RequestMethod.POST)
    @ResponseBody
    public Match addMatch(@RequestBody Match match) {
        return service.save(match);
    }

    @RequestMapping(value = "/matches/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteMatch(@PathVariable int id) {
        service.remove(id);
    }
}
