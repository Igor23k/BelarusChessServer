package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAll();

    Person getById(int id);

    Person save(Person person);

    void remove(int id);
}
