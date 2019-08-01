package by.of.bobrchess.belaruschess.server.repository;

import by.of.bobrchess.belaruschess.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user WHERE u_email = ?1", nativeQuery = true)
    User findByEmail(String email);

    @Query(value = "SELECT * FROM user WHERE u_is_coach = true", nativeQuery = true)
    List<User> getCoaches();

    @Query(value = "SELECT * FROM user LIMIT ?1", nativeQuery = true)
    List<User> getUsers(Integer count);

    @Query(value = "SELECT * FROM user WHERE u_name = ?1 OR u_surname =?1", nativeQuery = true)
    List<User> searchUsers(String text);
}
