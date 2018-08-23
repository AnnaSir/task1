package ru.anna.mytestpr.dao;

import ru.anna.mytestpr.jdo.User;

import java.util.List;

public interface UserDao {

 List<User> getAllUsers();
 User getUserById(Long userId);
 User getUserByName(String name);

}
