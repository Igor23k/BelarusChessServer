package by.of.bobrchess.belaruschess.server.repository.lite

import by.of.bobrchess.belaruschess.server.entity.lite.PlaceLite
import org.springframework.data.jpa.repository.JpaRepository

interface PlaceLiteRepository : JpaRepository<PlaceLite, Int>