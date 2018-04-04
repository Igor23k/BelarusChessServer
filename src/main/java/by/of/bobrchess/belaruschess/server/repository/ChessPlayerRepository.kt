package by.of.bobrchess.belaruschess.server.repository

import by.of.bobrchess.belaruschess.server.entity.ChessPlayer
import by.of.bobrchess.belaruschess.server.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface ChessPlayerRepository : JpaRepository<ChessPlayer, Int>