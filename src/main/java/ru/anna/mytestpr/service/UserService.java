package ru.anna.mytestpr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anna.mytestpr.dao.UserDao;
import ru.anna.mytestpr.jdo.User;
import ru.anna.mytestpr.utils.UserUtils;

import java.util.List;


@Service
public class UserService {

    private UserDao appUserDao;

    @Autowired
    public void setAppUserDao(UserDao appUserDao) {
        this.appUserDao = appUserDao;
    }


    public List<User> getAllUsers() {
        return appUserDao.getAllUsers();
    }

    public User getUser() {
        return appUserDao.getUserById(UserUtils.getCurrUser().getUserId());

    }
}
