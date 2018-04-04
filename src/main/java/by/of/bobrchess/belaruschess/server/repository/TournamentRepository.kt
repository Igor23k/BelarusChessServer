package by.of.bobrchess.belaruschess.server.repository

import by.of.bobrchess.belaruschess.server.entity.Tournament
import org.springframework.data.jpa.repository.JpaRepository

interface TournamentRepository : JpaRepository<Tournament, Int>