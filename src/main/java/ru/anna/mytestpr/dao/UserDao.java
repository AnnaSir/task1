package ru.anna.mytestpr.dao;

import ru.anna.mytestpr.jdo.User;

import java.util.Date;
import java.util.List;

public interface UserDao {

 List<User> getAllUsers();
 User getUserById(Long userId);
 User getUserByName(String name);
 void updateLastName(String lastName);
 void updateBirth(Date birth);
 void updateEmail(String email);
 void updatePass(String pass);
 void updateLogin(String login);

}
