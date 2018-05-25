package by.of.bobrchess.belaruschess.server.repository;

import by.of.bobrchess.belaruschess.server.entity.Tournament;
import by.of.bobrchess.belaruschess.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
    @Query(value = "select * from tournament where tr_name = ?1", nativeQuery = true)
    List<Tournament> searchTournaments(String text);
}
