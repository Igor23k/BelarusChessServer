package by.of.bobrchess.belaruschess.server.controller;

import by.of.bobrchess.belaruschess.server.entity.future.Team;
import by.of.bobrchess.belaruschess.server.service.future.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamService service;

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    @ResponseBody
    public List<Team> getAllTeams() {
        return service.getAll();
    }

    @RequestMapping(value = "/searchTeams", method = RequestMethod.GET)
    @ResponseBody
    public List<Team> searchTeams(@RequestParam String text) {
        return service.searchTeams(text);
    }

    @RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Team getTeam(@PathVariable int id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/team", method = RequestMethod.POST)
    @ResponseBody
    public Team addTeam(@RequestBody Team team) {
        return service.save(team);
    }

    @RequestMapping(value = "/team/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTeam(@PathVariable int id) {
        service.remove(id);
    }
}
