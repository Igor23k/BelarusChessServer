package by.of.bobrchess.belaruschess.server.repository.lite;

import by.of.bobrchess.belaruschess.server.entity.User;
import by.of.bobrchess.belaruschess.server.entity.lite.UserLite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserLiteRepository extends JpaRepository<UserLite, Long> {

    @Query(value = "SELECT * FROM user LIMIT ?1", nativeQuery = true)
    List<UserLite> getUsers(Integer count);

    @Query(value = "SELECT * FROM user WHERE u_name = ?1 OR u_surname =?1", nativeQuery = true)
    List<UserLite> searchUsers(String text);
}
