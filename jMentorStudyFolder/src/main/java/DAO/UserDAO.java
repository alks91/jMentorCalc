package DAO;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;
    private Session session;


    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public UserDAO(Session session) {
        this.session = session;
    }

    public List<User> getAllUser() {
        List result = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users_info");
            while (resultSet.next()) {
                result.add(
                        new User(Long.parseLong(resultSet.getString("id")),
                                resultSet.getString("name"),
                                resultSet.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

        public boolean addUser(User user) {
            boolean result = false;
            try {
                Statement stat = connection.createStatement();
                ResultSet resultSet = stat.executeQuery("select * from users_info where name='" + user.getName() + "'");
                if (!resultSet.next()) {
                    String sql = "insert into users_info(name, email) values (?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, user.getName());
                    statement.setString(2, user.getEmail());
                    statement.executeUpdate();
                    statement.close();
                    result = true;
                } else {
                    result = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
    }

    public void deleteUserById(Long id) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from users_info where id=" + id);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNameById(Long id, String name) {
        try {
            PreparedStatement statement = connection.prepareStatement("update users_info set name = ? where id = ?");
            statement.setString(1, name);
            statement.setLong(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(Long id) {
        User user = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users_info where id=" + id);
            resultSet.next();
            user = new User(Long.valueOf(resultSet.getString("id")),
                    resultSet.getString("name"),
                    resultSet.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUserHibern() {
        Transaction transaction =session.beginTransaction();
        List<User> users = session.createQuery("from model.User").list();
        transaction.commit();
        session.close();
        return users;
    }

    public boolean addUserHibern(User user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return true;
    }

    public void deleteUserByIdHibern(Long id) {
        User user = getUserById(id);
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public User getUserByIdHibern(Long id) {
        return session.getReference(User.class, id);
    }

    public void updateNameByIdHibern(Long id, String name) {
        User user = getUserById(id);
        user.setName(name);
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }
}

