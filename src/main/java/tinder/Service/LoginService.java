package tinder.Service;

import tinder.DAO.UserDaoDB;
import tinder.Entity.User;

import java.util.List;

public class LoginService {
    private final UserDaoDB userDaoDB = new UserDaoDB();

    public User getUser(String mail, String password){
        List<User> users = userDaoDB.getAll();

        return users.stream()
                .filter(user -> user.getMail().equalsIgnoreCase(mail) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}