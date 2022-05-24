package by.of.bobrchess.belaruschess.server.repository.lite;

import by.of.bobrchess.belaruschess.server.entity.lite.TournamentLite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TournamentLiteRepository extends JpaRepository<TournamentLite, Integer> {

    String GET_UPCOMING_TOURNAMENTS = "SELECT * FROM tournament WHERE tournament.tr_finish > NOW()";

    @Query(value = GET_UPCOMING_TOURNAMENTS, nativeQuery = true)
    List<TournamentLite> getUpcomingTournamentsLite(Boolean upcomingOnly);
}
