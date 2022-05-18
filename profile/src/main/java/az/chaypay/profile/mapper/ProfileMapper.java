package az.chaypay.profile.mapper;

import az.chaypay.shared.profile.TipResponse;
import az.chaypay.shared.profile.CreateTipRequest;
import az.chaypay.shared.review.CreateReviewRequest;
import az.chaypay.shared.review.ReviewResponse;
import az.chaypay.shared.transaction.CreateTransactionRequest;
import az.chaypay.shared.transaction.CreateTransactionResponse;
import az.chaypay.shared.transaction.TransactionResponse;
import az.chaypay.shared.profile.ProfileResponse;
import az.chaypay.shared.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ProfileMapper {

    public static final ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    @Mapping(target = "ratingValue", source = "overallRating")
    @Mapping(target = "balance", source = "monthlyEarnings")
    public abstract ProfileResponse toProfileResponse(UserDTO user, Double overallRating, Double monthlyEarnings);

    public abstract CreateTransactionRequest toCreateTransactionRequest(CreateTipRequest request);

    @Mapping(target = "userId", source = "request.userId")
    @Mapping(target = "feedback", source = "request.feedback")
    @Mapping(target = "ratingValue", source = "request.ratingValue")
    @Mapping(target = "transactionId", source = "transaction.id")
    public abstract CreateReviewRequest toCreateReviewRequest(CreateTipRequest request, CreateTransactionResponse transaction);

    @Mapping(target = "belongsTo", source = "belongsTo")
    @Mapping(target = "feedback", source = "review.feedback")
    @Mapping(target = "ratingValue", source = "review.ratingValue")
    @Mapping(target = "amount", source = "transaction.amount")
    @Mapping(target = "transactionId", source = "transaction.id")
    @Mapping(target = "createdAt", source = "transaction.createdAt")
    public abstract TipResponse toTipResponse(TransactionResponse transaction, ReviewResponse review, String belongsTo);
}
