package by.of.bobrchess.belaruschess.server.controller;

import by.of.bobrchess.belaruschess.server.entity.Country;
import by.of.bobrchess.belaruschess.server.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    CountryService service;

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    @ResponseBody
    public List<Country> getAllCountries() {
        return service.getAll();
    }

    @RequestMapping(value = "/countries/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Country getCountry(@PathVariable int id) {
      //  return service.getAll().get(id);
        return service.getById(id);
    }

    @RequestMapping(value = "/countries", method = RequestMethod.POST)
    @ResponseBody
    public Country addCountry(@RequestBody Country country) {
        return service.save(country);
    }

    @RequestMapping(value = "/countries/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteCountry(@PathVariable int id) {
        service.remove(id);
    }
}
