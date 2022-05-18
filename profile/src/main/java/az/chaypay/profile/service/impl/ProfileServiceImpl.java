package az.chaypay.profile.service.impl;

import az.chaypay.profile.mapper.ProfileMapper;
import az.chaypay.profile.service.ProfileService;
import az.chaypay.review.service.ReviewService;
import az.chaypay.shared.profile.TipResponse;
import az.chaypay.shared.profile.CreateTipRequest;
import az.chaypay.shared.profile.CreateTipResponse;
import az.chaypay.shared.review.ReviewResponse;
import az.chaypay.shared.transaction.TransactionResponse;
import az.chaypay.shared.profile.ProfileResponse;
import az.chaypay.shared.user.UserInfoResponse;
import az.chaypay.shared.user.UserRole;
import az.chaypay.shared.util.Triplet;
import az.chaypay.transaction.service.TransactionService;
import az.chaypay.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileMapper mapper;
    private final UserService userService;
    private final ReviewService reviewService;
    private final TransactionService transactionService;

    @Override
    public ProfileResponse getProfile(Long userId, Long teamId, UserRole role) {
        var user = userService.getById(userId);
        var ratingAndEarning = getRatingAndEarnings(userId, teamId, role);
        return mapper.toProfileResponse(user, ratingAndEarning.getFirst(), ratingAndEarning.getSecond());
    }

    private Pair<Double, Double> getRatingAndEarnings(Long userId, Long teamId, UserRole role) {
        Double overallRating;
        double monthlyEarning;
        if (role == UserRole.MANAGER) {
            overallRating = reviewService.getOverallTeamRating(teamId);
        } else {
            overallRating = reviewService.getOverallUserRating(userId);
        }
        monthlyEarning = 0.0;
        return Pair.of(overallRating, monthlyEarning);
    }

    @Override
    public List<TipResponse> getTipList(Long userId, Long teamId, UserRole role) {
        var result = getRatingsAndTransactions(userId, teamId, role);
        var ratingsMap = result.getFirst().stream()
                .collect(Collectors.toMap(ReviewResponse::getTransactionId, ReviewResponse::itself));
        var usersMap = result.getSecond().stream()
                .collect(Collectors.toMap(UserInfoResponse::getUserId, UserInfoResponse::itself));
        return result.getThird().stream()
                .map(transaction -> mapper.toTipResponse(
                        transaction,
                        ratingsMap.get(transaction.getId()),
                        usersMap.get(transaction.getUserId()).getFirstName())
                ).collect(Collectors.toList());
    }

    private Triplet<List<ReviewResponse>, List<UserInfoResponse>, List<TransactionResponse>>
    getRatingsAndTransactions(Long userId, Long teamId, UserRole role) {
        if (role == UserRole.MANAGER) {
            var ratings = reviewService.getAllByTeamId(teamId);
            var transactions = transactionService.getAllByTeamId(teamId);
            var users = userService.getAllByTeamId(teamId);
            return Triplet.of(ratings, users, transactions);
        }
        var ratings = reviewService.getAllByUserId(userId);
        var transactions = transactionService.getAllByUserId(userId);
        var users = Collections.<UserInfoResponse>emptyList();
        return Triplet.of(ratings, users, transactions);
    }

    @Override
    public CreateTipResponse createTip(CreateTipRequest request) {
        var transaction = transactionService.createTransaction(mapper.toCreateTransactionRequest(request));
        var review = reviewService.createRating(mapper.toCreateReviewRequest(request, transaction));
        return new CreateTipResponse(transaction.getId().toString(), transaction.getUrl());
    }
}
