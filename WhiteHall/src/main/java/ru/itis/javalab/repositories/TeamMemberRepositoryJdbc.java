package ru.itis.javalab.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.Role;
import ru.itis.javalab.models.TeamMember;
import ru.itis.javalab.repositories.interfaces.TeamMemberRepository;
import ru.itis.javalab.services.interfaces.RoleService;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TeamMemberRepositoryJdbc implements TeamMemberRepository {
    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate template;
    private RoleService roleService;

    //language=SQL
    private final String SQL_SELECT_ALL_BY_ROLE = "SELECT * FROM team_member WHERE role_id=?";

    //language=SQL
    private final String SQL_CREATE = "INSERT INTO team_member (first_name, last_name, role_id, text) VALUES (?, ?, ?, ?)";

    //language=SQL
    final String SQL_DELETE = "DELETE FROM team_member WHERE id= ?";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM team_member WHERE id= ?";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM team_member";

    //language=SQL
    private static final String SQL_SELECT_ALL_WITH_PAGES = "SELECT * FROM account ORDER BY id limit :limit offset :offset ";

    //language=SQL
    private static final String SQL_FIND_BY_NAME = "SELECT * FROM team_member WHERE first_name = ?";

    //language=SQL
    private static final String SQL_FIND_BY_ROLE = "SELECT * FROM team_member WHERE role_id = ?";

    private RowMapper<TeamMember> teamMemerRowMapper = (row, i) -> TeamMember.builder()
            .id(row.getInt("id"))
            .first_name(row.getString("first_name"))
            .last_name(row.getString("last_name"))
            .role_id(roleService.getRole(row.getInt("role_id")))
            .text(row.getString("text"))
            .build();

    public TeamMemberRepositoryJdbc(DataSource dataSource, RoleService roleService) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.roleService = roleService;
    }

    @Override
    public List<TeamMember> getAllByRole(Role role) {
        return template.query(SQL_SELECT_ALL_BY_ROLE, teamMemerRowMapper, role.getRole_id());
    }

    @Override
    public void save(TeamMember teamMember) {
        template.query(SQL_CREATE, teamMemerRowMapper,
                teamMember.getFirst_name(),
                teamMember.getLast_name(),
                teamMember.getRole_id(),
                teamMember.getText());
    }

    @Override
    public void delete(TeamMember teamMember) {
        template.update(SQL_DELETE, teamMember.getId());
    }

    //TODO может выпать NullPointer
    @Override
    public TeamMember findById(Integer id) {
        List<TeamMember> teamMembers = template.query(SQL_SELECT_BY_ID, teamMemerRowMapper, id);
        return teamMembers.get(0);
    }

    @Override
    public List<TeamMember> findAll() {
        return template.query(SQL_SELECT_ALL, teamMemerRowMapper);
    }

    @Override
    public List<TeamMember> findAll(int page, int size) {
        Map<String, Object> params = new HashMap<>();
        params.put("limit", size);
        params.put("offset", page * size);
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_WITH_PAGES, params, teamMemerRowMapper);
    }

    @Override
    public List<TeamMember> findMembersByName(String name) {
        return template.query(SQL_FIND_BY_NAME, teamMemerRowMapper, searchRequest(name));
    }

    @Override
    public List<TeamMember> findMembersByRole(String role) {
        return template.query(SQL_FIND_BY_ROLE, teamMemerRowMapper, roleService.getRoleByName(role).getId());
    }

    private String searchRequest(String name) {
        return "%" + name + "%";
    }

}
