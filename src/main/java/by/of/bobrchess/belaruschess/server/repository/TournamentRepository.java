package by.of.bobrchess.belaruschess.server.repository;

import by.of.bobrchess.belaruschess.server.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE tournament SET tr_count_players_in_team = ?2, tr_finish = ?3, tr_full_description = ?4, tr_image = ?5, tr_name = ?6, tr_short_description = ?7, tr_start = ?8, tr_place_id = ?9, tr_referee_id = ?10 WHERE (tr_id = ?1)", nativeQuery = true)
    void updateById(Long id, Integer count, String finish, String full, String image, String name, String shortDesc,
                    String start, Integer placeId, Long refereeId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tournament WHERE tr_id = ?1", nativeQuery = true)
    void removeById(Long id);

    @Query(value = "SELECT * FROM tournament WHERE tr_name = ?1", nativeQuery = true)
    List<Tournament> searchTournaments(String text);

    @Query(value = "SELECT * FROM tournament WHERE tr_id = ?1", nativeQuery = true)
    Tournament getById(Long id);
}
