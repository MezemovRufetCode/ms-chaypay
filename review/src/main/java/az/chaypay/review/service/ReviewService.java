package az.chaypay.review.service;

import az.chaypay.shared.review.CreateReviewRequest;
import az.chaypay.shared.review.ReviewResponse;

import java.util.List;

public interface ReviewService {
    List<ReviewResponse> getAllByTeamId(Long teamId);

    List<ReviewResponse> getAllByUserId(Long userId);

    Double getOverallTeamRating(Long teamId);

    Double getOverallUserRating(Long userId);

    ReviewResponse createRating(CreateReviewRequest request);
}
