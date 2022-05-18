package az.chaypay.review.service.impl;

import az.chaypay.review.mapper.ReviewMapper;
import az.chaypay.review.repository.ReviewRepository;
import az.chaypay.review.service.ReviewService;
import az.chaypay.shared.review.CreateReviewRequest;
import az.chaypay.shared.review.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;
    private final ReviewMapper mapper;

    @Override
    public List<ReviewResponse> getAllByTeamId(Long teamId) {
        return repository.getAllByTeamId(teamId).stream()
                .map(mapper::toRatingResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewResponse> getAllByUserId(Long userId) {
        return repository.getAllByUserId(userId).stream()
                .map(mapper::toRatingResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Double getOverallTeamRating(Long teamId) {
        return repository.getOverallTeamRating(teamId);
    }

    @Override
    public Double getOverallUserRating(Long userId) {
        return repository.getOverallUserRating(userId);
    }

    @Override
    public ReviewResponse createRating(CreateReviewRequest request) {
        return mapper.toRatingResponse(repository.save(mapper.toRatingEntity(request)));
    }
}
