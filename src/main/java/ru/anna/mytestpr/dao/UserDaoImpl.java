package ru.anna.mytestpr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.anna.mytestpr.jdo.User;
import ru.anna.mytestpr.utils.UserUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final UserRowMapper userRowMapper = new UserRowMapper();

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

    @Override
    public User getUserByName(String name) {
        Map<String, String> map = new HashMap<>();
        map.put("first_name", name);
        return namedParameterJdbcTemplate.queryForObject("SELECT * FROM SA.USERLIST WHERE first_name = :first_name", map, userRowMapper);
    }

    @Override
    public void updateLastName(String lastName) {
        Long userId = UserUtils.getCurrUser().getUserId();
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("last_name", lastName);
        namedParameterJdbcTemplate.update("UPDATE SA.USERLIST SET last_name =:last_name WHERE user_id=:user_id", map);

    }

    @Override
    public void updateBirth(Date birth) {
        Long userId = UserUtils.getCurrUser().getUserId();
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("birthday", birth);
        namedParameterJdbcTemplate.update("UPDATE SA.USERLIST SET birthday =:birthday WHERE user_id=:user_id", map);
    }

    @Override
    public void updateEmail(String email) {
        Long userId = UserUtils.getCurrUser().getUserId();
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("email", email);
        namedParameterJdbcTemplate.update("UPDATE SA.USERLIST SET email =:email WHERE user_id=:user_id", map);
    }

    @Override
    public void updatePass(String pass) {
        Long userId = UserUtils.getCurrUser().getUserId();
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("password", pass);
        namedParameterJdbcTemplate.update("UPDATE SA.USERLIST SET password =:password WHERE user_id=:user_id", map);
    }

    @Override
    public void updateLogin(String login) {
        Long userId = UserUtils.getCurrUser().getUserId();
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("first_name", login);
        namedParameterJdbcTemplate.update("UPDATE SA.USERLIST SET first_name =:first_name WHERE user_id=:user_id", map);
    }


    private static class UserRowMapper implements RowMapper<User> {

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
