package ru.anna.mytestpr.dao;

import ru.anna.mytestpr.jdo.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getOrderList();
    void addOrder(Long tourId, Boolean confirmed);
    List <Order> getOrder();
    void delete(Long orderId);
    Integer getCountOrders(Long tourId);
}
