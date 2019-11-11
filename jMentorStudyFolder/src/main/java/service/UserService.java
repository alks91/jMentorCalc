package service;

import DAO.UserDAO;
import model.User;
import org.hibernate.SessionFactory;
import util.DBConnect;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private static UserService userService;
    public static UserService getInstance() {
        if(userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    private SessionFactory sessionFactory = DBConnect.getSessionFactory();

    public List<User> getAllUser() {
        return getUserDao().getAllUser();
    }

    public boolean addUser(User user) {
        return getUserDao().addUser(user);
    }

    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").
                    append("localhost:").
                    append("3306/").
                    append("users?").
                    append("user=root&").
                    append("password=24867913").
                    append("&serverTimezone=UTC");;

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private static UserDAO getUserDao() {
        return new UserDAO(getMysqlConnection());
    }


    public void deleteUserById(Long id) {
        new UserDAO(getMysqlConnection()).deleteUserById(id);
    }

    public User getUserById(Long id) {
        return new UserDAO(getMysqlConnection()).getUserById(id);
    }

    public void updateNameById(Long id, String name) {
        new UserDAO(getMysqlConnection()).updateNameById(id, name);
    }

                  //hibernate

    public List<User> getAllUserHibern() {
        return new UserDAO(sessionFactory.openSession()).getAllUser();
    }

    public boolean addUserHibern(User user) {
        return new UserDAO(sessionFactory.openSession()).addUser(user);
    }


    public void deleteUserByIdHibern(Long id) {
        new UserDAO(sessionFactory.openSession()).deleteUserById(id);
    }

    public User getUserByIdHibern(Long id) {
        return new UserDAO(sessionFactory.openSession()).getUserById(id);
    }

    public void updateNameByIdHibern(Long id, String name) {
        new UserDAO(sessionFactory.openSession()).updateNameById(id, name);
    }


    }
