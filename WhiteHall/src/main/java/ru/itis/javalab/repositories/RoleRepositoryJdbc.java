package ru.itis.javalab.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.Role;
import ru.itis.javalab.repositories.interfaces.RoleRepository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class RoleRepositoryJdbc implements RoleRepository {
    private DataSource dataSource;
    private final JdbcTemplate template;

    //language=SQL
    private final String SQL_SELECT_BY_NAME = "SELECT * FROM role WHERE name=?";

    //language=SQL
    final String SQL_CREATE = "INSERT INTO role ( name ) VALUES (?)";

    //language=SQL
    final String SQL_DELETE = "DELETE FROM role WHERE id= ?";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM role WHERE id= ?";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM role";


    private RowMapper<Role> roleRowMapper = (row, i) -> Role.builder()
            .role_id(row.getInt("id"))
            .name(row.getString("name"))
            .build();

    public RoleRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(dataSource);
    }


    @Override
    public Role findByName(String name) {
        List<Role> roles = template.query(SQL_SELECT_BY_NAME, roleRowMapper, name);
        return roles.isEmpty() ? roles.get(0) : null;
    }

    @Override
    public void save(Role role) {
        template.query(SQL_CREATE, roleRowMapper, role.getName());
    }

    @Override
    public void delete(Role role) {
        template.update(SQL_DELETE, role.getRole_id());
    }

    @Override
    public Role findById(Integer id) {
        List<Role> roles = template.query(SQL_SELECT_BY_ID, roleRowMapper, id);
        return !roles.isEmpty() ? roles.get(0) : null;
    }

    @Override
    public List<Role> findAll() {
        return template.query(SQL_SELECT_ALL, roleRowMapper);
    }
}
