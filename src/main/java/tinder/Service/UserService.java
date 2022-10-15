package tinder.Service;

import tinder.DAO.*;
import tinder.Entity.User;

import java.util.List;

public class UserService {
    private final UserDaoDB userDaoDatabase = new UserDaoDB();

    public List<User> getAllUsers(){
        return userDaoDatabase.getAll();
    }

    public User getUser(int id){
        return userDaoDatabase.get(id);
    }


}
