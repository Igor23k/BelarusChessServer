package by.of.bobrchess.belaruschess.server.repository;

import by.of.bobrchess.belaruschess.server.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    String GET_USER_TOURNAMENT_RESULT = "SELECT tournament.tr_name, tournamentteamranking.ttr_points, tournamentteamranking.ttr_position,\n" +
            "tournament.tr_start, tournament.tr_image\n" +
            "FROM team_players join team ON team_players.tm_id = team.tm_id\n" +
            "join tournamentteamranking ON team_players.tm_id = tournamentteamranking.ttr_team_id\n" +
            "join tournament ON tr_id = tournamentteamranking.ttr_tournament_id\n" +
            "WHERE u_id = ?1";

    String GET_UPCOMING_TOURNAMENTS = "SELECT * FROM tournament WHERE tournament.tr_finish > NOW()";

    @Modifying
    @Transactional
    @Query(value = "UPDATE tournament SET tr_count_players_in_team = ?2, tr_finish = ?3, tr_full_description = ?4, tr_image = ?5, tr_name = ?6, tr_start = ?7, tr_place_id = ?8, tr_referee_id = ?9, tr_tours_count = ?10, tr_created_by = ?11 WHERE (tr_id = ?1)", nativeQuery = true)
    void updateById(Long id, Integer count, Date finish, String full, Byte[] image, String name,
                    Date start, Integer placeId, Long refereeId, Integer toursCount, Long createdBy);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tournament WHERE tr_id = ?1", nativeQuery = true)
    void removeById(Long id);

    @Query(value = "SELECT * FROM tournament WHERE tr_name = ?1", nativeQuery = true)
    List<Tournament> searchTournaments(String text);

    @Query(value = "SELECT * FROM tournament WHERE tr_id = ?1", nativeQuery = true)
    Tournament getById(Long id);

    @Query(value = GET_USER_TOURNAMENT_RESULT + " LIMIT ?2", nativeQuery = true)
    List<Object[]> getUserTournamentsResult(Long userId, Long limit);

    @Query(value = GET_USER_TOURNAMENT_RESULT, nativeQuery = true)
    List<Object[]> getUserTournamentsResult(Long userId);

    @Query(value = GET_UPCOMING_TOURNAMENTS, nativeQuery = true)
    List<Tournament> getUpcomingTournaments(Boolean upcomingOnly);
}
