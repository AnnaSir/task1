package ru.anna.mytestpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.anna.mytestpr.jdo.AppUser;
import ru.anna.mytestpr.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getAllUsers",
            method = RequestMethod.GET)

    @ResponseBody
    public String users(){

        return userService.allUsersAct();
    }

}
