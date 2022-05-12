package by.of.bobrchess.belaruschess.server.service;

import by.of.bobrchess.belaruschess.server.entity.Place;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PlaceService {
    List<Place> getAll();

    Place getById(int id);

    Place save(Place place, MultipartFile image, Boolean isImageUpdated) throws IOException;

    void remove(int id);
}
