package ru.anna.mytestpr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anna.mytestpr.dao.UserDao;
import ru.anna.mytestpr.exceptions.BusinessException;
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

        if (userDao.getAllUsers().isEmpty())
            throw new BusinessException("there is no users");
        else return userDao.getAllUsers();
    }

    public User getUser() {
        try {
            return userDao.getUserById(UserUtils.getCurrUser().getUserId());
        } catch (BusinessException e) {
            throw new BusinessException("user does not exist");
        }
    }

    public String userUpdate(Integer a, String s) {


            switch (a) {
                case 1:
                    if (userDao.getCountUsers(s) > 0) return "Пользователь существует";
                    else {
                        userDao.updateLogin(s);
                        return "Логин изменен";
                    }
                case 2:
                    userDao.updatePass(s);
                    return "Пароль обновлен";
                case 3:
                    userDao.updateEmail(s);
                    return "Email изменен";
            }
            throw new BusinessException("Ошибка при редактировании");
    }

    public String updateBirth(Date d) {
        userDao.updateBirth(d);
        return "Дата рождения изменена";
    }
}
