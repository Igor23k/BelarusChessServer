package by.of.bobrchess.belaruschess.server.repository.future;

import by.of.bobrchess.belaruschess.server.entity.future.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    @Query(value = "SELECT * FROM team WHERE tm_name = ?1", nativeQuery = true)
    List<Team> searchTeams(String text);
}
