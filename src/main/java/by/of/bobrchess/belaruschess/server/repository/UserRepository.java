package by.of.bobrchess.belaruschess.server.repository;

import by.of.bobrchess.belaruschess.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from user where u_email = ?1", nativeQuery = true)
    User findByEmail(String email);

    @Query(value = "select * from user limit ?1", nativeQuery = true)
    List<User> getUsers(Integer count);

    @Query(value = "select * from user where u_name = ?1 or u_surname =?1", nativeQuery = true)
    List<User> searchUsers(String text);
}
