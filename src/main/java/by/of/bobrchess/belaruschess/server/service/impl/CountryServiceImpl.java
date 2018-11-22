package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Country;
import by.of.bobrchess.belaruschess.server.repository.CountryRepository;
import by.of.bobrchess.belaruschess.server.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Autowired
    private CountryRepository repository;

    public List<Country> getAll() {
        return repository.findAll();
    }

    public Country getById(int id) {
        return repository.getOne(id);
    }

    public Country save(Country country) {
        return repository.saveAndFlush(country);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}
