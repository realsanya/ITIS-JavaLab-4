package ru.itis.javalab.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.interfaces.UserRepository;
import ru.itis.javalab.services.interfaces.ImageService;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepositoryJdbc implements UserRepository {
    private final JdbcTemplate template;
    private ImageService imageService = null;

    //language=SQL
    private final String SQL_SELECT_ALL_BY_EMAIL = "SELECT * FROM user WHERE email=?";

    //language=SQL
    private final String SQL_CREATE = "INSERT INTO user (first_name, last_name, email, password, image_id, state, confirm_code) VALUES (?, ?, ?, ?, ?, ?, ?)";
    //language=SQL
    final String SQL_DELETE = "DELETE FROM user WHERE id= ?";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM user WHERE id= ?";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM user";

    public UserRepositoryJdbc(DataSource dataSource, ImageService imageService) {
        this.template = new JdbcTemplate(dataSource);
        this.imageService = imageService;
    }

    private RowMapper<User> userRowMapper = (row, i) -> User.builder()
            .id(row.getLong("id"))
            .first_name(row.getString("first_name"))
            .last_name(row.getString("last_name"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .image_id(imageService.getImage(row.getInt("image_id")))
            .build();


    @Override
    public boolean save(User user) {
        System.out.println(user.getFirst_name() + user.getLast_name() + user.getEmail() + user.getPassword());
        try {
            template.update(SQL_CREATE,
                    user.getFirst_name(),
                    user.getLast_name(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getImage_id().getId(),
                    user.getState(),
                    user.getConfirmCode());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void delete(User user) {
        template.update(SQL_DELETE, user.getId());
    }


    @Override
    public User findById(Long id) {
        List<User> users = template.query(SQL_SELECT_BY_ID, userRowMapper, id);
        return !users.isEmpty() ? users.get(0) : null;
    }

    @Override
    public List<User> findAll() {
        return template.query(SQL_SELECT_ALL, userRowMapper);
    }


    @Override
    public User findByEmail(String email) {
        List<User> users = template.query(SQL_SELECT_ALL_BY_EMAIL, userRowMapper, email);
        return !users.isEmpty() ? users.get(0) : null;
    }
}
