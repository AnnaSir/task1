package ru.anna.mytestpr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.anna.mytestpr.jdo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final UserRowMapper userRowMapper= new UserRowMapper();

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("AppUserDaoImpl getAllUsers");
        return namedParameterJdbcTemplate.query("SELECT * FROM SA.USERLIST", userRowMapper);
    }

    @Override
    public User getUserById(Long userId) {
        Map<String, Long> map = new HashMap<>();
        map.put("user_id", userId);
        return namedParameterJdbcTemplate.queryForObject("SELECT * FROM SA.USERLIST WHERE user_id = :user_id", map, userRowMapper);
    }

    private static class UserRowMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setUserId(resultSet.getLong("user_id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setActive(resultSet.getBoolean("active"));
            user.setBirthday(resultSet.getDate("birthday"));
            return user;
        }
    }



}
