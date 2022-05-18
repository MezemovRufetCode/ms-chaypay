package az.chaypay.review.repository;

import az.chaypay.review.repository.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT AVG(rating.ratingValue) FROM Review rating " +
           "WHERE rating.userId = :userId " +
           "AND rating.status = az.chaypay.shared.review.ReviewStatus.ACTIVE")
    Double getOverallUserRating(@Param("userId") Long userId);

    @Query("SELECT AVG(rating.ratingValue) FROM Review rating " +
           "WHERE rating.teamId = :teamId " +
           "AND rating.status = az.chaypay.shared.review.ReviewStatus.ACTIVE")
    Double getOverallTeamRating(@Param("teamId") Long teamId);

    @Query("SELECT rating FROM Review rating " +
           "WHERE rating.teamId = :userId " +
           "AND rating.status = az.chaypay.shared.review.ReviewStatus.ACTIVE")
    List<Review> getAllByUserId(@Param("userId") Long userId);

    @Query("SELECT rating FROM Review rating " +
           "WHERE rating.teamId = :teamId " +
           "AND rating.status = az.chaypay.shared.review.ReviewStatus.ACTIVE")
    List<Review> getAllByTeamId(@Param("teamId") Long teamId);
}