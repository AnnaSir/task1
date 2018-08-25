package ru.anna.mytestpr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.anna.mytestpr.utils.MyFileUtils;

import javax.annotation.PostConstruct;

@Component
@Profile({"!test"})
public class InitDb {
    private JdbcTemplate jdbcTemplate;
    private final static String INIT_DB=MyFileUtils.scriptLoader("/sql/createAllTables.sql");
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void initBd() {

        jdbcTemplate.execute(INIT_DB);
    }
}
