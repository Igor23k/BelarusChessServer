package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getAll();

    Place getById(int id);

    Place save(Place place);

    void remove(int id);
}
