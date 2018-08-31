package ru.anna.mytestpr.dao;

import ru.anna.mytestpr.jdo.User;

import java.util.List;

public interface UserDao {

 List<User> getAllUsers();
 User getUserById(Long userId);
 User getUserByName(String name);
 void updateLastName(String lastName);
 void updateEmail(String email);
 void updateLogin(String login);
 Integer getCountUsers(String name);

}
