package ru.anna.mytestpr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.anna.mytestpr.jdo.AppUser;
import ru.anna.mytestpr.utils.MyFileUtils;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AppUserDaoImpl implements AppUserDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;


    private final static String CREATE_USER_TABLE = MyFileUtils.scriptLoader("/sql/creation.sql");
    private final static String REQUEST = MyFileUtils.scriptLoader("/sql/request.sql");

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init(){
        jdbcTemplate.execute(CREATE_USER_TABLE);
    }


    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<AppUser> getAllUsers() {
        System.out.println("AppUserDaoImpl getAllUsers");
        return namedParameterJdbcTemplate.query(REQUEST, new UserRowMapper());

    }
    private static class UserRowMapper implements RowMapper<AppUser>{

        @Override
        public AppUser mapRow(ResultSet resultSet, int i) throws SQLException {
            AppUser appUser = new AppUser();
            appUser.setUserActive(resultSet.getBoolean("user_active"));
            appUser.setUserBirthday(resultSet.getDate("user_birthday"));
            appUser.setUserId(resultSet.getLong("user_id"));
            appUser.setUserName(resultSet.getString("user_name"));
            return appUser;
        }
    }



}
