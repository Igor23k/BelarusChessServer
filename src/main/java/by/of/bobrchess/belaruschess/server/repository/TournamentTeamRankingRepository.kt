package by.of.bobrchess.belaruschess.server.repository

import by.of.bobrchess.belaruschess.server.entity.TournamentTeamRanking
import org.springframework.data.jpa.repository.JpaRepository

interface TournamentTeamRankingRepository : JpaRepository<TournamentTeamRanking, Int>