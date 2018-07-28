package ru.anna.mytestpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.anna.mytestpr.service.UserService;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getAllActiveUsers",
            method = RequestMethod.GET)

    @ResponseBody
    public String users() {

        return userService.allUsersAct();
    }

    @RequestMapping(value = "/getAllUsers",
            method = RequestMethod.GET)

    @ResponseBody
    public String users1() {

        return userService.allUsers();


    }
}
