package ru.itis.javalab.services;

import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.ReviewDto;
import ru.itis.javalab.models.Review;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.ReviewReposiroty;

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
    public List<ReviewDto> getAllReviewsByUser(User user) {
        return ReviewDto.from(reviewReposiroty.findReviewByUserId(user));
    }

    @Override
    public void save(Review review) {
        reviewReposiroty.save(review);
    }

}
