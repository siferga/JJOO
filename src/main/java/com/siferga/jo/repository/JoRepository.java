package com.siferga.jo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class JoRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> callSpJoPaysRankedForYear(int year) {
        String sql = "CALL spJoPaysClassement(?)";
        return jdbcTemplate.queryForList(sql, year);
    }
}
