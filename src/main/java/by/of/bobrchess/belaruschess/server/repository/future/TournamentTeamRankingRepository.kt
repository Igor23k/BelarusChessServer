package by.of.bobrchess.belaruschess.server.repository.future

import by.of.bobrchess.belaruschess.server.entity.future.TournamentTeamRanking
import org.springframework.data.jpa.repository.JpaRepository

interface TournamentTeamRankingRepository : JpaRepository<TournamentTeamRanking, Int>