package ru.itis.javalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.javalab.models.Review;
import ru.itis.javalab.models.User;

import java.util.List;

public interface ReviewReposiroty extends JpaRepository<Review, Long> {
    List<Review> findReviewByUserId(User user);
}
