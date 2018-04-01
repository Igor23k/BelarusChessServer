package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAll();
    Country getById(int id);
    Country save(Country country);
    void remove(int id);
}
