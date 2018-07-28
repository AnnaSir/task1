package ru.anna.mytestpr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anna.mytestpr.dao.AppUserDao;
import ru.anna.mytestpr.jdo.AppUser;


@Service
public class UserService {

    private AppUserDao appUserDao;

    @Autowired
    public void setAppUserDao(AppUserDao appUserDao) {
        this.appUserDao = appUserDao;
    }

    public String allUsers() {

        StringBuilder s = new StringBuilder();
        for (AppUser a : appUserDao.getAllUsers()
                ) {
            s.append(a.getUserName() + " " + a.getUserId() + " " + a.getUserBirthday() + " " + a.getUserActive() + "--");
        }
        return s.toString();


    }

    public String allUsersAct() {
        StringBuilder s = new StringBuilder();
        for (AppUser a : appUserDao.getAllUsers()
                ) {
            if (a.getUserActive())
            s.append(a.getUserName() + " " + a.getUserId() + " " + a.getUserBirthday() + " -- ");
        }
        return s.toString();
    }
}
