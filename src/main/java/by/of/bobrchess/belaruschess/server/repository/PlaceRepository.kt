package by.of.bobrchess.belaruschess.server.repository

import by.of.bobrchess.belaruschess.server.entity.Place
import org.springframework.data.jpa.repository.JpaRepository

interface PlaceRepository : JpaRepository<Place, Int>