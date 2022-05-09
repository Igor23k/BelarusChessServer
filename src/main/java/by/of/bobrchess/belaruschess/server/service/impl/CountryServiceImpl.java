package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Country;
import by.of.bobrchess.belaruschess.server.repository.CountryRepository;
import by.of.bobrchess.belaruschess.server.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository repository;

    @Override
    public List<Country> getAll() {
        return repository.findAll();
    }

    @Override
    public Country getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public Country save(Country country) {
        return repository.saveAndFlush(country);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
