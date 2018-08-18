package ru.anna.mytestpr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anna.mytestpr.dao.OrderDao;
import ru.anna.mytestpr.dao.TourDao;
import ru.anna.mytestpr.dao.UserDao;
import ru.anna.mytestpr.jdo.Order;

import java.util.List;

@Service
public class OrderService {

    private OrderDao orderDao;
    private TourDao tourDao;
    private UserDao userDao;

    public String addOrder(Long userId, Long tourId) {

        if (orderDao.getCountOrders(userId,tourId)>0){
            return "Заказ существует";

        }

        orderDao.addOrder(userId, tourId,true);//todo заменить true на знач. в соотв. с кол-вом свободных заказов

        if (orderDao.getCountOrders(userId,tourId)>0){
            return "Заказ успешно добавлен";

        }
        return "Ошибка при добавлении заказа";

    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Order getOrder(Long orderId){
        return orderDao.getOrder(orderId);
    }


    public List<Order> getOrderList() {
        return orderDao.getOrderList();
    }

    public void oderDel(Long orderId) {
        orderDao.delete(orderId);
    }


}
