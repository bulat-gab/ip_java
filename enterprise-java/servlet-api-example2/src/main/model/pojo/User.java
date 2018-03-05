package main.model.pojo;

/**
 * Created by admin on 20.04.2017.
 */
public class User {

    private long id;
    private String login;
    private String password;
    private boolean isBlocked;

    public User(long id, String login, String password, boolean isBlocked){

        this.id = id;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
