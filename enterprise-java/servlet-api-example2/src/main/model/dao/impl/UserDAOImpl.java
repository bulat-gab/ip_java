package main.model.dao.impl;

import main.controllers.LoginServlet;
import main.model.dao.interfaces.UserDAO;
import main.model.pojo.Group;
import main.model.pojo.User;
import main.model.utils.DataSourceFactory;
import main.services.UserServiceImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by admin on 20.04.2017.
 */
public class UserDAOImpl implements UserDAO {
    static {
        PropertyConfigurator.configure(LoginServlet.class.getClassLoader().getResource("log4j.properties"));
    }

    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    @Override
    public User findUserByLoginAndPassword(String login, String password) {
        User user = null;
        String sql = "SELECT * FROM users WHERE login = ? AND password = ?;";

        try {
            Connection connection = DataSourceFactory.getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            user = new User(resultSet.getLong("id"), resultSet.getString("login"),
                    resultSet.getString("password"), resultSet.getBoolean("is_blocked"));

            LOGGER.debug("got user");

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.debug(e);
        }

//        if (group == null) { //TODO Надо что ли?
//            throw new SQLException("Record with PK = " + id + " not found.");
//        }

        return user;
    }

    @Override
    public User getById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public User save(User entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Long insert(User entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int update(User entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int delete(User entity) {
        throw new UnsupportedOperationException();
    }
}
