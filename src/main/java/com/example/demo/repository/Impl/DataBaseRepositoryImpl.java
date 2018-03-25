package com.example.demo.repository.Impl;

import com.example.demo.model.LineModel;
import com.example.demo.repository.DataBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DataBaseRepositoryImpl implements DataBaseRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DataBaseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LineModel> findAll() {
        String sql = "SELECT * FROM line_table";
        List<LineModel> list = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            list.add(new LineModel((Long) row.get("id"), (String) row.get("line_name")));
        }
        return list;
    }

    @Override
    public void addOneLineByName(String name) {
        String sql = "INSERT INTO line_table(line_name) VALUE (?)";
        jdbcTemplate.update(sql, name);
    }

    @Override
    public String findById(Long id) {
        String sql = "SELECT line_name FROM line_table WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
    }

    @Override
    public List<LineModel> findAllByName(String name) {
        List<LineModel> list = new ArrayList<>();
        for (LineModel lineModel : findAll()) {
            if (lineModel.getName().equals(name)) {
                list.add(lineModel);
            }
        }
        return list;
    }
}
