package by.of.bobrchess.belaruschess.server.service.impl;

import by.of.bobrchess.belaruschess.server.entity.Place;
import by.of.bobrchess.belaruschess.server.repository.PlaceRepository;
import by.of.bobrchess.belaruschess.server.service.PlaceService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository repository;

    public List<Place> getAll() {
        return repository.findAll();
    }

    public Place getById(int id) {
        return repository.getOne(id);
    }

    public Place save(Place place, MultipartFile image, Boolean isImageUpdated) throws IOException {
        if (image != null) {
            place.setImage(ArrayUtils.toObject(image.getBytes()));
        } else if (!isImageUpdated) {
            place.setImage(repository.getOne(place.getId()).getImage());
        }
        return repository.saveAndFlush(place);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}
