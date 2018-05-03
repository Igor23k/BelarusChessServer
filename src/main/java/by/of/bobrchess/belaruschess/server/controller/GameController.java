package by.of.bobrchess.belaruschess.server.controller;

import by.of.bobrchess.belaruschess.server.entity.Game;
import by.of.bobrchess.belaruschess.server.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameService service;

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    @ResponseBody
    public List<Game> getAllGames() {
        return service.getAll();
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Game getGame(@PathVariable int id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    @ResponseBody
    public Game addCountry(@RequestBody Game game) {
        return service.save(game);
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteGame(@PathVariable int id) {
        service.remove(id);
    }
}
