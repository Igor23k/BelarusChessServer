package by.of.bobrchess.belaruschess.server.repository

import by.of.bobrchess.belaruschess.server.entity.Country
import by.of.bobrchess.belaruschess.server.entity.Rank
import org.springframework.data.jpa.repository.JpaRepository

interface RankRepository : JpaRepository<Rank, Int>