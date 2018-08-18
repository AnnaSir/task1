package ru.anna.mytestpr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.anna.mytestpr.jdo.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao{

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private OrderRowMap orderRowMap = new OrderRowMap();

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Integer getCountOrders(Long userId, Long tourId) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("tour_id", tourId);
        Object[] args = {userId,tourId};
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM SA.ORDERLIST WHERE USER_ID=? and tour_id=?", args, Integer.class);
    }

    @Override
    public void delete(Long orderId) {
        Map<String, Long> map = new HashMap<>();
        map.put("order_id", orderId);
        namedParameterJdbcTemplate.update("DELETE FROM SA.ORDERLIST WHERE ORDER_ID=:order_id", map);
    }

    @Override
    public Order getOrder(Long orderId) {
        Map<String, Long> map = new HashMap<>();
        map.put("order_id", orderId);
        return namedParameterJdbcTemplate.queryForObject("SELECT * FROM SA.ORDERLIST WHERE USER_ID=:order_id", map, orderRowMap);
    }

    @Override
    public List<Order> getOrderList()  {
        return namedParameterJdbcTemplate.query("SELECT * FROM SA.ORDERLIST", new OrderRowMap());
    }

    public void addOrder(Long userId, Long tourId, Boolean confirmed) {

        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("tour_id", tourId);
        map.put("confirmed", confirmed);
        namedParameterJdbcTemplate.update("INSERT INTO SA.ORDERLIST (user_id, user_name, tour_name, confirmed, time_key) select a.user_id, FIRST_NAME, name, :confirmed, sysdate from SA.USERLIST a, SA.TOURLIST b where  a.user_id=:user_id and b.tour_id =:tour_id", map);
    }

    public static class OrderRowMap implements RowMapper<Order>{

        @Override
        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
            Order order = new Order();
            order.setOrderId(resultSet.getLong("order_id"));
            order.setUserId(resultSet.getLong("user_id"));
            order.setUserName(resultSet.getString("user_name"));
            order.setTourId(resultSet.getLong("tour_id"));
            order.setTourName(resultSet.getString("tour_name"));
            order.setConfirmed(resultSet.getBoolean("confirmed"));
            order.setTimeKey(resultSet.getTimestamp("time_key"));

            return order;
        }
    }
}