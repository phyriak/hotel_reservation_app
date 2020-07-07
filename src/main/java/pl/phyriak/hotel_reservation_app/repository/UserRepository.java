package pl.phyriak.hotel_reservation_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.phyriak.hotel_reservation_app.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    @Query("select t from User t where t.username = :username")
    Optional<User> findByUsername(String username);

    @Query("select t from User t where t.user_id = :id")
    Optional<User> findByUser_id(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE User t SET t.password = :newPassword WHERE t.user_id = :id")
    void updateUserPassword(Long id, String newPassword);
}
