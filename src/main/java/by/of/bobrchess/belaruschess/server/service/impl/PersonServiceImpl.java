package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Person;
import by.of.bobrchess.belaruschess.server.repository.PersonRepository;
import by.of.bobrchess.belaruschess.server.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> getAll() {
        return repository.findAll();
    }

    public Person getById(int id) {
        return repository.getOne(id);
    }

    public Person save(Person person) {
        return repository.saveAndFlush(person);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}
