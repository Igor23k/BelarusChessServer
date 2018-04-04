package by.of.bobrchess.belaruschess.server.repository

import by.of.bobrchess.belaruschess.server.entity.Game
import org.springframework.data.jpa.repository.JpaRepository

interface GameRepository : JpaRepository<Game, Int>