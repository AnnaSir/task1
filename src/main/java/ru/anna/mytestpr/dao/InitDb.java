package ru.anna.mytestpr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.anna.mytestpr.utils.MyFileUtils;

import javax.annotation.PostConstruct;

@Component
public class InitDb {
    private JdbcTemplate jdbcTemplate;
    private final static String CREATE_ORDER_LIST=MyFileUtils.scriptLoader("/sql/createAllTables.sql");
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void initBd() {

        jdbcTemplate.execute(CREATE_ORDER_LIST);
    }
}
