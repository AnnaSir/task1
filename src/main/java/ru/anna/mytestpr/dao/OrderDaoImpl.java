package ru.anna.mytestpr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.anna.mytestpr.jdo.Order;
import ru.anna.mytestpr.utils.UserUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao{

    private JdbcTemplate jdbcTemplate;

    @Override
    public Order getOrder(Long orderId) {
        Map<String, Long> parameters = new HashMap<>();
        parameters.put("order_id", orderId);
        return namedParameterJdbcTemplate.queryForObject("SELECT * FROM SA.ORDERLIST WHERE order_id = :order_id", parameters, orderRowMap);
    }

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
    public Integer getCountOrders(Long tourId) {
        Long userId = UserUtils.getCurrUser().getUserId();
        Object[] args = {userId,tourId};
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM SA.ORDERLIST WHERE USER_ID=? and tour_id=?", args, Integer.class);
    }

    @Override
    public void delete(Long orderId) {
        Map<String, Long> parameters = new HashMap<>();
        parameters.put("order_id", orderId);
        namedParameterJdbcTemplate.update("DELETE FROM SA.ORDERLIST WHERE ORDER_ID=:order_id", parameters);
    }

    @Override
    public List<Order> getOrders() {
        Long userId = UserUtils.getCurrUser().getUserId();
        Map<String, Long> map = new HashMap<>();

        map.put("user_id", userId);
        return namedParameterJdbcTemplate.query("SELECT * FROM SA.ORDERLIST WHERE USER_ID=:user_id", map, orderRowMap);
    }

    @Override
    public List<Order> getOrderList()  {
        return namedParameterJdbcTemplate.query("SELECT * FROM SA.ORDERLIST", new OrderRowMap());
    }

    public void addOrder(Long tourId, Boolean confirmed) {
        Long userId = UserUtils.getCurrUser().getUserId();
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("tour_id", tourId);
        map.put("confirmed", confirmed);
        namedParameterJdbcTemplate.update("INSERT INTO SA.ORDERLIST (user_id, tour_id, confirmed, time_key) select user_id, tour_id, :confirmed, sysdate from SA.USERLIST, SA.TOURLIST where user_id=:user_id and tour_id =:tour_id", map);
    }

    public static class OrderRowMap implements RowMapper<Order>{

        @Override
        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
            Order order = new Order();
            order.setOrderId(resultSet.getLong("order_id"));
            order.setUserId(resultSet.getLong("user_id"));
            order.setTourId(resultSet.getLong("tour_id"));
            order.setConfirmed(resultSet.getBoolean("confirmed"));
            order.setTimeKey(resultSet.getTimestamp("time_key"));
            return order;
        }
    }
}