package ru.anna.mytestpr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anna.mytestpr.dao.UserDao;
import ru.anna.mytestpr.jdo.User;
import ru.anna.mytestpr.utils.UserUtils;

import java.util.Date;
import java.util.List;


@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUser() {
        return userDao.getUserById(UserUtils.getCurrUser().getUserId());

    }

    public String userUpdate(Integer a, String  s) {
        switch (a) {
            case 1:
                userDao.updateLogin(s);
                return "Логин изменен";
            case 2:
                userDao.updatePass(s);
                return "Пароль обновлен";
            case 3:
                userDao.updateEmail(s);
                return "Email изменен";
        }
        return "Ошибка при редактировании";
    }

    public String updateBirth(Date d) {
        userDao.updateBirth(d);
        return "Дата рождения изменена";
    }
}
