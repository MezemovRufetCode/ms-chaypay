package az.chaypay.review.mapper;

import az.chaypay.review.repository.entity.Review;
import az.chaypay.shared.review.CreateReviewRequest;
import az.chaypay.shared.review.ReviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ReviewMapper {

    public static final ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    public abstract ReviewResponse toRatingResponse(Review review);

    @Mapping(target = "status", ignore = true)
    public abstract Review toRatingEntity(CreateReviewRequest request);

}
