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
    //TODO добавить image
    private DataSource dataSource;
    private JdbcTemplate template;
    private ImageService imageService;

    //language=SQL
    private final String SQL_SELECT_ALL_BY_EMAIL = "SELECT * FROM user WHERE email=?";

    //language=SQL
    private final String SQL_CREATE = "INSERT INTO user (first_name, last_name, email, password, image_id) VALUES (?, ?, ?, ?, ?)";

    //language=SQL
    final String SQL_DELETE = "DELETE FROM user WHERE id= ?";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM user WHERE id= ?";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM user";

    private RowMapper<User> userRowMapper = (row, i) -> User.builder()
            .id(row.getInt("id"))
            .first_name(row.getString("first_name"))
            .last_name(row.getString("last_name"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .image_id(imageService.getImage(row.getInt("image_id")))
            .build();

    public UserRepositoryJdbc(DataSource dataSource, ImageService imageService) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(dataSource);
        this.imageService = imageService;
    }

    @Override
    public void save(User user) {
        System.out.println(user.getFirst_name() + user.getLast_name() + user.getEmail() + user.getPassword());
        template.update(SQL_CREATE, user.getFirst_name(),
                user.getLast_name(),
                user.getEmail(),
                user.getPassword(),
                user.getImage_id().getId());
    }

    @Override
    public void delete(User user) {
        template.update(SQL_DELETE, user.getId());
    }


    @Override
    public User findById(Integer id) {
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
