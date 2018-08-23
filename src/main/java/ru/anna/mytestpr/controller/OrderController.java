package ru.anna.mytestpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.anna.mytestpr.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    private OrderService orderService;

    @RequestMapping(value = "/addOrder")
    public String addOrder(Model model, Long userId, Long tourId) {
        model.addAttribute("result", orderService.addOrder(userId, tourId));
        return "orderInsert";
    }

    @RequestMapping(value = "/delOrder")
    @ResponseBody
    public String delOrder(Model model, @RequestParam(required = false) Long orderId) {
        orderService.oderDel(orderId);
        return "Oder by user " + orderId + " deleted";
    }

    @RequestMapping(value = "/getOrders")
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.getOrderList());
        return "allOrderInfo";
    }

}
