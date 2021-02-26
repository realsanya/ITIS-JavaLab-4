package ru.itis.javalab.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.Image;
import ru.itis.javalab.repositories.interfaces.ImageRepository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ImageRepositoryJdbc implements ImageRepository {
    private DataSource dataSource;
    private JdbcTemplate template;

    //language=SQL
    private final String SQL_SELECT_BY_PATH = "SELECT * FROM image WHERE path=?";

    //language=SQL
    private final String SQL_CREATE = "INSERT INTO image (type, path) VALUES (?, ?)";

    //language=SQL
    final String SQL_DELETE = "DELETE FROM image WHERE id= ?";

    //language=SQL
    private final String SQL_UPDATE = "SELECT * from image WHERE `image`.id = LAST_INSERT_ID()";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM image WHERE id=?";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM image";

    private RowMapper<Image> imageRowMapper = (row, i) -> Image.builder()
            .id(row.getInt("id"))
            .type(row.getString("type"))
            .path(row.getString("path"))
            .build();

    public ImageRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Image findByPath(String path) {
        List<Image> images = template.query(SQL_SELECT_BY_PATH, imageRowMapper, path);
        return !images.isEmpty() ? images.get(0) : null;
    }

    @Override
    public boolean save(Image image) {
        template.update(SQL_CREATE, image.getType(), image.getPath());
        return true; //TODO
    }

    @Override
    public void delete(Image image) {
        template.update(SQL_DELETE, image);
    }

    @Override
    public void update(Image image) {
        template.update(SQL_UPDATE, image.getPath());
    }

    @Override
    public Image findById(Integer id) {
        List<Image> images = template.query(SQL_SELECT_BY_ID, imageRowMapper, id);
        return !images.isEmpty() ? images.get(0) : null;
    }

    @Override
    public List<Image> findAll() {
        return template.query(SQL_SELECT_ALL, imageRowMapper);
    }
}
