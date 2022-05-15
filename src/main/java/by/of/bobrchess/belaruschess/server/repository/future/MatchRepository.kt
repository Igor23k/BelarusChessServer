package by.of.bobrchess.belaruschess.server.repository.future

import by.of.bobrchess.belaruschess.server.entity.future.Match
import org.springframework.data.jpa.repository.JpaRepository

interface MatchRepository : JpaRepository<Match, Int>