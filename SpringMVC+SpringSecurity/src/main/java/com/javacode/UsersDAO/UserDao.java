package com.javacode.UsersDAO;

import com.javacode.model.User;

import java.util.List;

public interface UserDao {
    public List<User> allUsersList();
    public User getUserById(Long id);
    public User getUserByName(String username);
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUserById(Long id);

}
