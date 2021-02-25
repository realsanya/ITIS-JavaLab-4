package ru.itis.javalab.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.Review;
import ru.itis.javalab.repositories.interfaces.ReviewReposiroty;
import ru.itis.javalab.services.interfaces.UserService;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ReviewRepositoryJdbc implements ReviewReposiroty {
    private DataSource dataSource;
    private final JdbcTemplate template;
    private UserService userService;

    //language=SQL
    private final String SQL_SELECT_ALL_BY_USER_ID = "SELECT * FROM review WHERE user_id= ? ";

    //language=SQL
    final String SQL_CREATE = "INSERT INTO review ( user_id, date, text ) VALUES (?, ?, ?)";

    //language=SQL
    final String SQL_DELETE = "DELETE FROM review WHERE id= ?";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM review WHERE id= ?";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM review";

    //TODO
    private RowMapper<Review> reviewRowMapper = (row, i) -> Review.builder()
            .id(row.getInt("id"))
            .user_id(userService.getUserById(row.getInt("user_id")))
            .date(row.getDate("date"))
            .text(row.getString("text"))
            .build();

    public ReviewRepositoryJdbc(DataSource dataSource, UserService userService) {
        this.dataSource = dataSource;
        this.userService = userService;
        this.template = new JdbcTemplate(dataSource);
    }

    //TODO
    @Override
    public List<Review> findByUserID(Integer user_id) {
        return template.query(SQL_SELECT_ALL_BY_USER_ID, reviewRowMapper, user_id);
    }

    @Override
    public void save(Review review) {
        template.update(SQL_CREATE, review.getUser_id(), review.getDate(), review.getText());
    }

    @Override
    public void delete(Review review) {
        template.update(SQL_DELETE, review.getId());
    }

    @Override
    public Review findById(Integer id) {
        List<Review> reviews = template.query(SQL_SELECT_BY_ID, reviewRowMapper, id);
        return reviews.isEmpty() ? reviews.get(0) : null;
    }

    @Override
    public List<Review> findAll() {
        return template.query(SQL_SELECT_ALL, reviewRowMapper);
    }
}
