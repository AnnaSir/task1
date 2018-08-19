package ru.anna.mytestpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.anna.mytestpr.service.UserService;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/getUser")
    public String getCurrUser(Model model, @RequestParam(required = false) Long id) {

        try {
            if (id != null) {
                model.addAttribute("user", userService.getUserById(id));
            }
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


}




