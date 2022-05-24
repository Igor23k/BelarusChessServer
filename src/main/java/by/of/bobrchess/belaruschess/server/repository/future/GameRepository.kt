package by.of.bobrchess.belaruschess.server.repository.future

import by.of.bobrchess.belaruschess.server.entity.future.Game
import org.springframework.data.jpa.repository.JpaRepository

interface GameRepository : JpaRepository<Game, Int>