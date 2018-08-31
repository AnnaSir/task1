package ru.anna.mytestpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.anna.mytestpr.exceptions.BusinessException;
import ru.anna.mytestpr.service.UserService;


@Controller
public class UserController {

    @ExceptionHandler(BusinessException.class)
    public ModelAndView handleBusinessException(BusinessException e) {
        ModelAndView modelAndView = new ModelAndView("noUserException");
        modelAndView.addObject("result", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleIOException(Exception e) {
        ModelAndView modelAndView = new ModelAndView("exceptions");
        modelAndView.addObject("result", e.getMessage());
        modelAndView.addObject("eClass", e.getClass());
        return modelAndView;
    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getUser")
    public String getCurrUser(Model model) {
        try {
            model.addAttribute("user", userService.getUser());
            return "userInfo";
        } catch (EmptyResultDataAccessException e) {
            return "noUserException";
        }
    }

    @RequestMapping("/getAllUsers")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "allUsersInfo";
    }

    @RequestMapping(value = "/userUpdate")
    public String userUpdate(Model model, Integer a, String s) {
        model.addAttribute("user", userService.userUpdate(a, s));
        return "userUpdate";
    }
}




