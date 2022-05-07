package by.of.bobrchess.belaruschess.server.repository;

import by.of.bobrchess.belaruschess.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user WHERE u_email = ?1", nativeQuery = true)
    User findByEmail(String email);

    @Query(value = "SELECT * FROM user WHERE u_is_coach = true", nativeQuery = true)
    List<User> getCoaches();

    @Query(value = "SELECT * FROM user WHERE u_is_organizer = true", nativeQuery = true)
    List<User> getReferees();

    @Query(value = "SELECT * FROM user LIMIT ?1", nativeQuery = true)
    List<User> getUsers(Integer count);

    @Query(value = "SELECT * FROM user WHERE u_name = ?1 OR u_surname =?1", nativeQuery = true)
    List<User> searchUsers(String text);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user SET u_name = ?2, u_surname = ?3, u_patronymic = ?4, u_birthday = ?5, u_email = ?6, u_password = ?7," +
            "u_is_coach = ?8, u_is_admin = ?9, u_is_organizer = ?10, u_is_Male = ?11, u_rank_id = ?12, u_country_id = ?13, " +
            "u_rating = ?14, u_coach = ?15, u_image = ?16 WHERE (u_id = ?1)", nativeQuery = true)
    void updateById(Long id, String name, String surname, String patronymic, String birthday, String email,
                    String password, Boolean beCoach, Boolean beAdmin, Boolean beOrganizer, Boolean beMale, Integer rankId,
                    Integer countryId, Integer rating, String coach, Byte[] image);

}
