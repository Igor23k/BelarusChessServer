package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.Country;
import by.of.bobrchess.belaruschess.server.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

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
