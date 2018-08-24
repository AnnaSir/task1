package ru.anna.mytestpr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anna.mytestpr.dao.OrderDao;
import ru.anna.mytestpr.dao.TourDao;
import ru.anna.mytestpr.jdo.Order;
import ru.anna.mytestpr.utils.UserUtils;

import java.util.List;

@Service
public class OrderService {

    private OrderDao orderDao;

    @Autowired
    public void setTourDao(TourDao tourDao) {
        this.tourDao = tourDao;
    }

    private TourDao tourDao;

    public String addOrder(Long tourId) {

        Long userId = UserUtils.getCurrUser().getUserId();

        if (orderDao.getCountOrders(tourId) > 0) {
            return "Заказ существует";
        }

        if (tourDao.getTourById(tourId).getCountLimit() == 0) {
            return "Туров не осталось";
        }

        orderDao.addOrder(tourId, true);
        if (orderDao.getCountOrders(tourId) == 1) {
            tourDao.tourUpdate(tourId, tourDao.getTourById(tourId).getCountLimit() - 1);
            return "Заказ успешно добавлен";
        }

        return "Ошибка при добавлении заказа";
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> getOrders() {
        return orderDao.getOrder();
    }

    public List<Order> getOrderList() {
        return orderDao.getOrderList();
    }

    public void oderDel(Long orderId) {
        orderDao.delete(orderId);
    }


}
