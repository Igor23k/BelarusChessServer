package by.of.bobrchess.belaruschess.server.controller;

import by.of.bobrchess.belaruschess.server.entity.Place;
import by.of.bobrchess.belaruschess.server.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaceController {

    @Autowired
    PlaceService service;

    @RequestMapping(value = "/places", method = RequestMethod.GET)
    @ResponseBody
    public List<Place> getAllPlaces() {
        return service.getAll();
    }

    @RequestMapping(value = "/place/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Place getPlace(@PathVariable int id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/place", method = RequestMethod.POST)
    @ResponseBody
    public Place addPlace(@RequestBody Place place) {
        return service.save(place);
    }

    @RequestMapping(value = "/place/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int deletePlace(@PathVariable int id) {
        service.remove(id);
        return id;
    }
}
