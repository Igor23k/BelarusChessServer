package by.of.bobrchess.belaruschess.server.repository

import by.of.bobrchess.belaruschess.server.entity.TournamentTeam
import org.springframework.data.jpa.repository.JpaRepository

interface TournamentTeamRepository : JpaRepository<TournamentTeam, Int>