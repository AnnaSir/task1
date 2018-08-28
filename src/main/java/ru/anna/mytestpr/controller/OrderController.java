package ru.anna.mytestpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.anna.mytestpr.exceptions.BusinessException;
import ru.anna.mytestpr.service.OrderService;

@Controller
public class OrderController {

    @ExceptionHandler(BusinessException.class)
    public ModelAndView handleBusinessException (BusinessException e) {
        ModelAndView modelAndView = new ModelAndView("noUserException");
        modelAndView.addObject("result", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleIOException (Exception e) {
        ModelAndView modelAndView = new ModelAndView("exceptions");
        modelAndView.addObject("result", e.getMessage());
        modelAndView.addObject("eClass", e.getClass());
        return modelAndView;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    private OrderService orderService;

    @RequestMapping(value = "/addOrder")
    public String addOrder(Model model, Long tourId) {
        model.addAttribute("result", orderService.addOrder(tourId));
        return "orderInsert";
    }

    @RequestMapping(value = "/delOrder")
    public String delOrder(Model model, Long orderId) {
        orderService.oderDel(orderId);
        return "orderDel";
    }

    @RequestMapping(value = "/getUserOrders")
    public String getUserOrders(Model model) {
        model.addAttribute("orders", orderService.getOrders());
        return "orderInfo";
    }
}
