package by.of.bobrchess.belaruschess.server.controller;

import by.of.bobrchess.belaruschess.server.entity.Rank;
import by.of.bobrchess.belaruschess.server.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RankController {

    @Autowired
    RankService service;

    @RequestMapping(value = "/ranks", method = RequestMethod.GET)
    @ResponseBody
    public List<Rank> getAllCountries() {
        return service.getAll();
    }

    @RequestMapping(value = "/rank/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Rank getRank(@PathVariable int id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/ranks", method = RequestMethod.POST)
    @ResponseBody
    public Rank addRank(@RequestBody Rank rank) {
        return service.save(rank);
    }

    @RequestMapping(value = "/rank/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteRank(@PathVariable int id) {
        service.remove(id);
    }
}
