package ru.itis.javalab.repositories.interfaces;

import ru.itis.javalab.models.Review;

import java.util.List;

public interface ReviewReposiroty extends CrudRepository<Review, Integer> {
    List<Review> findByUserID(Integer user_id);
}
