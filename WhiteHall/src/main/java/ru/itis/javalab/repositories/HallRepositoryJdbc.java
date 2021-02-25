package ru.itis.javalab.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.Hall;
import ru.itis.javalab.repositories.interfaces.HallRepository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class HallRepositoryJdbc implements HallRepository {
    private DataSource dataSource;
    private JdbcTemplate template;

    //language=SQL
    private final String SQL_SELECT_ALL_BY_COST = "SELECT * FROM hall WHERE cost=?";

    //language=SQL
    private final String SQL_CREATE = "INSERT INTO hall (name, cost) VALUES (?, ?)";

    //language=SQL
    final String SQL_DELETE = "DELETE FROM hall WHERE id= ?";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM hall WHERE id= ?";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM hall";

    private RowMapper<Hall> hallRowMapper = (row, i) -> Hall.builder()
            .id(row.getInt("id"))
            .name(row.getString("name"))
            .cost(row.getInt("cost"))
            .build();

    public HallRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Hall> findAllByCost(Integer cost) {
        return template.query(SQL_SELECT_ALL_BY_COST, hallRowMapper, cost);
    }

    @Override
    public void save(Hall hall) {
        template.update(SQL_CREATE, hall.getName(), hall.getCost());
    }

    @Override
    public void delete(Hall hall) {
        template.update(SQL_DELETE, hall.getId());
    }

    @Override
    public Hall findById(Integer id) {
        List<Hall> halls = template.query(SQL_SELECT_BY_ID, hallRowMapper, id);
        return halls.isEmpty() ? halls.get(0) : null;
    }

    @Override
    public List<Hall> findAll() {
        return template.query(SQL_SELECT_ALL, hallRowMapper);
    }
}
