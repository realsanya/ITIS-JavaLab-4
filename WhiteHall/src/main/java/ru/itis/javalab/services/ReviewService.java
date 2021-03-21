package ru.itis.javalab.services;

import ru.itis.javalab.dto.ReviewDto;
import ru.itis.javalab.models.Review;
import ru.itis.javalab.models.User;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> getAllReviews();

    List<ReviewDto> getAllReviewsByUser(User user);

    void save(Review review);
}
