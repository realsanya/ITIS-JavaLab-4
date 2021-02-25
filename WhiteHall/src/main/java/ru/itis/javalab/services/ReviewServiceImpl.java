package ru.itis.javalab.services;

import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.ReviewDto;
import ru.itis.javalab.models.Review;
import ru.itis.javalab.repositories.interfaces.ReviewReposiroty;
import ru.itis.javalab.services.interfaces.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewReposiroty reviewReposiroty;

    public ReviewServiceImpl(ReviewReposiroty reviewReposiroty) {
        this.reviewReposiroty = reviewReposiroty;
    }

    @Override
    public List<ReviewDto> getAllReviews() {
        return ReviewDto.from(reviewReposiroty.findAll());
    }

    @Override
    public List<ReviewDto> getAllReviewsByUserID(Integer user_id) {
        return ReviewDto.from(reviewReposiroty.findByUserID(user_id));
    }

    @Override
    public ReviewDto getReview(Integer id) {
        return ReviewDto.from(reviewReposiroty.findById(id));
    }

    @Override
    public void addReview(ReviewDto review) {
        reviewReposiroty.save(
                Review.builder()
                        .user_id(review.getUser_id())
                        .date(review.getDate())
                        .text(review.getText())
                        .build()
        );
    }
}
