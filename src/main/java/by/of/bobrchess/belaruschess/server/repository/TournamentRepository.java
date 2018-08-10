package by.of.bobrchess.belaruschess.server.repository;

import by.of.bobrchess.belaruschess.server.entity.Country;
import by.of.bobrchess.belaruschess.server.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Blob;
import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
    @Query(value = "SELECT * FROM tournament WHERE tr_name = ?1", nativeQuery = true)
    List<Tournament> searchTournaments(String text);

    @Query(value = "INSERT INTO tournament (tr_name, tr_description, tr_count_players_in_team, tr_place_id, tr_referee_id) VALUES (?1,?2,?3,?4,?5)", nativeQuery = true)
    Tournament addTournament(String name, String description, Integer countPlayers, Integer placeId, Long refereeId);
}
