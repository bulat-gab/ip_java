package main.model.dao.interfaces;

import main.model.pojo.User;

/**
 * Created by admin on 20.04.2017.
 */
public interface UserDAO extends DAO<User, Long> {
    User findUserByLoginAndPassword(String login, String password);
}
