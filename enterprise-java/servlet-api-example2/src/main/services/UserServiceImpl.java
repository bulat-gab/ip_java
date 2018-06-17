package main.services;

import main.controllers.LoginServlet;
import main.model.dao.impl.UserDAOImpl;
import main.model.pojo.User;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by admin on 20.04.2017.
 */
public class UserServiceImpl implements UserService {
    static {
        PropertyConfigurator.configure(LoginServlet.class.getClassLoader().getResource("log4j.properties"));
    }

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    private static UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public User auth(String login, String password) {
        User user = userDAO.findUserByLoginAndPassword(login, password);

        //LOGGER.debug("user: " + user);

        if((user != null) && user.isBlocked()){
            return null;
        }

        //LOGGER.debug("user not blocked ");

        return user;
    }
}
