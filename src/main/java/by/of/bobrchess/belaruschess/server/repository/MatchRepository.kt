package by.of.bobrchess.belaruschess.server.repository

import by.of.bobrchess.belaruschess.server.entity.Match
import org.springframework.data.jpa.repository.JpaRepository

interface MatchRepository : JpaRepository<Match, Int>