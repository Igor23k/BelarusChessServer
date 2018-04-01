package by.of.bobrchess.belaruschess.server.controller;

import by.of.bobrchess.belaruschess.server.entity.Country;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Country getCountry() {
        return createMockCountry();
    }

    private Country createMockCountry() {
        Country country = new Country();
        country.setId(1);
        country.setAbbreviation("BLR");
        country.setName("Belarus");
        return country;
    }
}
