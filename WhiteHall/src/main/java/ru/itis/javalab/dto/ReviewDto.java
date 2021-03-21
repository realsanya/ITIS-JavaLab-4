package ru.itis.javalab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalab.models.Review;
import ru.itis.javalab.models.User;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {
    private Long id;
    private User userId;
    private Date date;
    private String text;

    public static ReviewDto from(Review review) {
        if (review == null) {
            return null;
        }
        return ReviewDto.builder()
                .id(review.getId())
                .userId(review.getUserId())
                .date(review.getDate())
                .text(review.getText())
                .build();
    }

    public static List<ReviewDto> from(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewDto::from)
                .collect(Collectors.toList());
    }
}
