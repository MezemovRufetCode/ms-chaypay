package az.chaypay.user.repository;

import az.chaypay.user.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByQrCode(String qrCode);

    Optional<User> findByPhoneNumber(String phoneNumber);

    @Query("SELECT user FROM User user " +
           "WHERE user.team.id = :teamId " +
           "AND user.status = az.chaypay.shared.user.UserStatus.ACTIVE")
    List<User> getAllByTeamId(@Param("teamId") Long teamId);
}