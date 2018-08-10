package by.of.bobrchess.belaruschess.server.repository;

import by.of.bobrchess.belaruschess.server.entity.Team;
import by.of.bobrchess.belaruschess.server.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    @Query(value = "SELECT * FROM team WHERE tm_name = ?1", nativeQuery = true)
    List<Team> searchTeams(String text);
}
