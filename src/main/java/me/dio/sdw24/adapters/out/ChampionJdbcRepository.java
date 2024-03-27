package me.dio.sdw24.adapters.out;

import me.dio.sdw24.domain.model.Champion;
import me.dio.sdw24.domain.ports.ChampionRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ChampionJdbcRepository implements ChampionRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Champion> rowMapper;

    public ChampionJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = ((rs, rowNum) -> new Champion(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getString("lore"),
                rs.getString("image_url")
        ));
    }

    @Override
    public List<Champion> findAll() {
        return jdbcTemplate.query("SELECT * FROM CHAMPION", rowMapper);
    }

    @Override
    public Optional<Champion> findById(Long id) {
        String sql = "SELECT * FROM CHAMPION WHERE id = ?";
        Champion champion = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return Optional.ofNullable(champion);
    }
}
